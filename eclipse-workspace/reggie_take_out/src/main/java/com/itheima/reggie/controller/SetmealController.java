package com.itheima.reggie.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.R;
import com.itheima.reggie.dto.SetmealDto;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.entity.Setmeal;
import com.itheima.reggie.service.CategoryService;
import com.itheima.reggie.service.SetmealDishService;
import com.itheima.reggie.service.SetmealService;

import lombok.extern.slf4j.Slf4j;

/**
 * 套餐管理
 */
@RestController
@RequestMapping("/setmeal")
@Slf4j
public class SetmealController {

	@Autowired
	private SetmealService setmealService;

	@Autowired
	private SetmealDishService setmealDishService;

	@Autowired
	private CategoryService categoryService;

	/**
	 * 新增套餐
	 * 
	 * @param setmealDto
	 * @return
	 */
	@PostMapping
	public R<String> save(@RequestBody SetmealDto setmealDto) {
		log.info("新增套餐: {}", setmealDto);
		setmealService.saveWithDish(setmealDto);
		return R.success("新增套餐成功");

	}

	@GetMapping("/page")
	public R<Page> page(int page, int pageSize, String name) {
		// 创建分页构造器对象
		Page<Setmeal> pageInfo = new Page<>(page, pageSize);
		// SetmealDto中有属性private String categoryName分类名称
		Page<SetmealDto> dtoPage = new Page<>();

		LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<Setmeal>();
		// 添加查询条件，根据name进行like模糊查询
		queryWrapper.like(name != null, Setmeal::getName, name);
		// 添加排序条件，根据更新时间降序排序
		queryWrapper.orderByDesc(Setmeal::getUpdateTime);

		// 这里封装成R<Page>对象返回的话，
		// 套餐分类对象Page<Setmeal>,Setmeal里面只存储了categoryId,页面展示时需要分类名称
		setmealService.page(pageInfo, queryWrapper);

		// pageInfo分页查询后的结果给它拷贝到dtoPage中,忽略records属性
		BeanUtils.copyProperties(pageInfo, dtoPage, "records");
		List<Setmeal> records = pageInfo.getRecords();

		// 遍历records
		List<SetmealDto> list =

				records.stream().map((item) -> {

					// 自己new 的Setmeal对象里面没有赋值
					SetmealDto setmealDto = new SetmealDto();
					// 将setmeal对象中的值，拷贝到setmealDto中
					BeanUtils.copyProperties(item, setmealDto);

					// 得到分类id
					Long categoryId = item.getCategoryId();
					// 根据分类id查询分类对象，这里需要注入categoryService

					Category category = categoryService.getById(categoryId);
					if (category != null) {
						// 分类名称
						String categoryName = category.getName();

						setmealDto.setCategoryName(categoryName);
					}

					return setmealDto;

				}).collect(Collectors.toList());

		// List<SetmealDto> list = null;//将返回结果赋值给list

		dtoPage.setRecords(list);

		return R.success(dtoPage);// 服务器响应的数据与页面所需要的数据格式不一致
	}

	/**
	 * 删除套餐
	 * 
	 * @param ids
	 * @return
	 */
	@DeleteMapping
	public R<String> delete(@RequestParam List<Long> ids) {// 加注解@RequestParam可以正确接收到参数，声明参数类型单个或多个元素

		log.info("ids: {}", ids);

		setmealService.removeWithDish(ids);

		return R.success("套餐数据删除成功");
	}

	/**
	 * 根据条件查询套餐数据
	 * 
	 * @param setmeal
	 * @return
	 */
	@GetMapping("/list")
	public R<List<Setmeal>> list(Setmeal setmeal) {
		LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(setmeal.getCategoryId() != null, Setmeal::getCategoryId, setmeal.getCategoryId());
		queryWrapper.eq(setmeal.getStatus() != null, Setmeal::getStatus, setmeal.getStatus());
		queryWrapper.orderByDesc(Setmeal::getUpdateTime);

		List<Setmeal> list = setmealService.list(queryWrapper);

		return R.success(list);
	}

}
