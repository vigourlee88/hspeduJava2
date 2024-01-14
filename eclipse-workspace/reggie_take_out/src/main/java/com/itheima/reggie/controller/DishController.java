package com.itheima.reggie.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.R;
import com.itheima.reggie.dto.DishDto;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.entity.Dish;
import com.itheima.reggie.entity.DishFlavor;
import com.itheima.reggie.service.CategoryService;
import com.itheima.reggie.service.DishFlavorService;
import com.itheima.reggie.service.DishService;

import lombok.extern.slf4j.Slf4j;

/**
 * 菜品管理
 */
@RestController
@RequestMapping("/dish")
@Slf4j
public class DishController {
	@Autowired
	private DishService dishService;

	@Autowired
	private DishFlavorService dishFlavorService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 新增菜品
	 * 
	 * @param dishDto
	 * @return
	 */
	@PostMapping
	public R<String> save(@RequestBody DishDto dishDto) {// JSON数据需要添加注解@RequestBody
		log.info(dishDto.toString());

		// 需要操作两张表，就需要在dishService中扩展新的方法
		dishService.saveWithFlavor(dishDto);

		// 清理所有菜品的缓存数据
		// Set keys = redisTemplate.keys("dish_*");
		// redisTemplate.delete(keys);

		// 清理某个分类下面的菜品缓存数据
		String key = "dish_" + dishDto.getCategoryId() + "_1";
		redisTemplate.delete(key);

		return R.success("新增菜品成功");
	}

	/**
	 * 菜品信息的分页查询
	 * 
	 * @param page
	 * @param pageSize
	 * @param name
	 * @return
	 */
	@GetMapping("/page")
	public R<Page> page(int page, int pageSize, String name) {

		// 构造分页构造器对象
		Page<Dish> pageInfo = new Page<>(page, pageSize);
		// Page泛型中Dish对象中，没有categoryName属性，为与页面一一对应
		Page<DishDto> dishDtoPage = new Page<>();

		// 条件构造器
		LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();

		// 添加过滤条件
		queryWrapper.like(name != null, Dish::getName, name);

		// 添加排序条件
		queryWrapper.orderByDesc(Dish::getUpdateTime);

		// 执行分页查询
		dishService.page(pageInfo, queryWrapper);

		// 对象拷贝,忽略属性records，对应的是List集合
		BeanUtils.copyProperties(pageInfo, dishDtoPage, "records");

		List<Dish> records = pageInfo.getRecords();

		// records处理成list集合
		// List<DishDto> list = null;
		// dishDtoPage.setRecords(list);dishDtoPage对象来赋值

		// 基于recoeds来进行处理得到list集合，item代表Dish
		// 遍历每个菜品对对象
		List<DishDto> list = records.stream().map((item) -> {
			DishDto dishDto = new DishDto();

			// 把当前遍历的item对象中普通属性，拷贝到DishDto中
			BeanUtils.copyProperties(item, dishDto);

			// 以下操作是 查询数据库，把categoryName传入进来，设置到dishDto中
			Long categoryId = item.getCategoryId();// 拿到每个菜品对应的 分类id
			// 根据分类id查询分类表最终得到分类名称
			// 这里需要分类名称CategoryService 注入CategoryService
			// 根据id 查询分类对象Category
			Category category = categoryService.getById(categoryId);

			if (category != null) {
				// 得到分类的名称
				String categoryName = category.getName();
				dishDto.setCategoryName(categoryName);
			}

			// dishDto里面除了有 categoryName属性，extends Dish,普通属性通过对象拷贝，拷贝过来
			return dishDto;

		}).collect(Collectors.toList());// 遍历records对象过程中，创建dishDto对象，collect收集起来,转成集合复制给List<DishDto> list

		dishDtoPage.setRecords(list);// list集合对象赋给dishDtoPage对象的records属性

		return R.success(dishDtoPage);// 返回对象pageInfo改成dishDtoPage
	}

	/**
	 * 根据id查询菜品信息和对应的口味信息
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public R<DishDto> get(@PathVariable Long id) {

		DishDto dishDto = dishService.getByIdWithFlavor(id);

		return R.success(dishDto);
	}

	/**
	 * 修改菜品(同新增菜品，请求方式不一样)
	 * 
	 * @param dishDto
	 * @return
	 */
	@PutMapping
	public R<String> update(@RequestBody DishDto dishDto) {// JSON数据需要添加注解@RequestBody
		log.info(dishDto.toString());

		// 需要操作两张表，就需要在dishService中扩展新的方法
		dishService.updateWithFlavor(dishDto);

		// 清理所有菜品的缓存数据
		// Set keys = redisTemplate.keys("dish_*");
		// redisTemplate.delete(keys);

		// 清理某个分类下面的菜品缓存数据
		String key = "dish_" + dishDto.getCategoryId() + "_1";
		redisTemplate.delete(key);

		return R.success("修改菜品成功");
	}

	/**
	 * 根据条件查询对应的菜品数据
	 * 
	 * @param dish
	 * @return
	 */
//	@GetMapping("/list")
//	public R<List<Dish>> list(Dish dish) {
//
//		// 构造查询条件
//		LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
//		queryWrapper.eq(dish.getCategoryId() != null, Dish::getCategoryId, dish.getCategoryId());
//		// 添加条件，查询状态为1(起售状态)的菜品
//		queryWrapper.eq(Dish::getStatus, 1);
//
//		// 添加排序条件
//		queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
//
//		List<Dish> list = dishService.list(queryWrapper);
//
//		return R.success(list);
//	}

	@GetMapping("/list")
	public R<List<DishDto>> list(Dish dish) {

		List<DishDto> dishDtoList = null;

		// 动态构造key
		String key = "dish_" + dish.getCategoryId() + "_" + dish.getStatus();// dish_1397844391040167938_1

		// 先从redis中获取缓存数据
		dishDtoList = (List<DishDto>) redisTemplate.opsForValue().get(key);

		if (dishDtoList != null) {
			// 如果存在，直接返回，无需查询数据库
			return R.success(dishDtoList);
		}

		// 构造查询条件
		LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(dish.getCategoryId() != null, Dish::getCategoryId, dish.getCategoryId());
		// 添加条件，查询状态为1(起售状态)的菜品
		queryWrapper.eq(Dish::getStatus, 1);

		// 添加排序条件
		queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);

		List<Dish> list = dishService.list(queryWrapper);

		dishDtoList = list.stream().map((item) -> {

			DishDto dishDto = new DishDto();

			// 把当前遍历的item对象中普通属性，拷贝到DishDto中
			BeanUtils.copyProperties(item, dishDto);

			// 以下操作是 查询数据库，把categoryName传入进来，设置到dishDto中
			Long categoryId = item.getCategoryId();// 拿到每个菜品对应的 分类id
			// 根据分类id查询分类表最终得到分类名称
			// 这里需要分类名称CategoryService 注入CategoryService
			// 根据id 查询分类对象Category
			Category category = categoryService.getById(categoryId);

			if (category != null) {
				// 得到分类的名称
				String categoryName = category.getName();
				dishDto.setCategoryName(categoryName);
			}
			// 当前菜品id
			Long dishId = item.getId();// item就是Dish
			LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper<DishFlavor>();
			lambdaQueryWrapper.eq(DishFlavor::getDishId, dishId);

			// SQL select * from dish_flavor where dish_id = ?
			List<DishFlavor> dishFlavorList = dishFlavorService.list(lambdaQueryWrapper);
			dishDto.setFlavors(dishFlavorList);

			return dishDto;

		}).collect(Collectors.toList());// 遍历records对象过程中，创建dishDto对象，collect收集起来,转成集合复制给List<DishDto> list

		// 如果不存在，需要查询数据库，将查询到的菜品数据缓存到Redis
		redisTemplate.opsForValue().set(key, dishDtoList, 60, TimeUnit.MINUTES);

		return R.success(dishDtoList);
	}

}
