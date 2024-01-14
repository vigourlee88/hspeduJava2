package com.itheima.reggie.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.common.CustomException;
import com.itheima.reggie.dto.SetmealDto;
import com.itheima.reggie.entity.Setmeal;
import com.itheima.reggie.entity.SetmealDish;
import com.itheima.reggie.mapper.SetmealMapper;
import com.itheima.reggie.service.SetmealDishService;
import com.itheima.reggie.service.SetmealService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {

	@Autowired
	private SetmealDishService setmealDishService;

	@Override
	/**
	 * 新增套餐，同时需要保存套餐和菜品关联关系
	 * 
	 * @param setmealDto
	 */
	@Transactional // 操作2张表，保证操作事务的一致性
	public void saveWithDish(SetmealDto setmealDto) {
		// 保存套餐的基本信息，操作setmeal，执行insert操作
		this.save(setmealDto);

		// 集合中存储的关联关系实体SetmealDish，里面有setmealId(无值),dishId(有值)
		// 遍历集合，拿到每个实体SetmealDish，将setmealId赋值
		List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
		setmealDishes.stream().map((item) -> {
			item.setSetmealId(setmealDto.getId());
			return item;
		}).collect(Collectors.toList());

		// 保存集合setmealDishes之前对其进行处理，即遍历它
		// 保存套餐和菜品的关联信息-注入setmealDishService，操作setmeal_dish执行insert操作
		setmealDishService.saveBatch(setmealDishes);// 批量保存

	}

	/**
	 * 删除套餐，同时需要删除套餐和菜品的关联数据
	 * 
	 * @param ids
	 */
	@Transactional
	public void removeWithDish(List<Long> ids) {

		// 查询套餐的状态，确定是否可以删除
		// select count(*) from setmeal where id in 1,2,3 and status = 1;
		LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<Setmeal>();
		queryWrapper.in(Setmeal::getId, ids);
		queryWrapper.eq(Setmeal::getStatus, 1);

		int count = this.count(queryWrapper);

		if (count > 0) {
			// 如果不能删除就抛出一个业务异常
			throw new CustomException("套餐正在售卖中，不能删除");
		}

		// 如果可以删除，先删除套餐表中的数据--setmeal
		this.removeByIds(ids);

		// 删除关系表中的数据--setmealDish
		// delete from setmealdish where setmeal_id in(1,2,3)
		LambdaQueryWrapper<SetmealDish> lambdaQueryWrapper = new LambdaQueryWrapper<SetmealDish>();
		lambdaQueryWrapper.in(SetmealDish::getId, ids);

		setmealDishService.remove(lambdaQueryWrapper);

	}

}
