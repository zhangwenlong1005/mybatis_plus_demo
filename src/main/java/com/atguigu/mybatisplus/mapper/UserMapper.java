package com.atguigu.mybatisplus.mapper;

import com.atguigu.mybatisplus.entity.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.ExceptionUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author wenlong-Zhang
 * @create 2022-10-12 9:43
 */

/*
* idea在注入的userMapper报错是因为，找不到注入的对象，因为类是动态创建的，但是程序可以正确执行
*    加上@Repository就不报红了
* */

/*
* BaseMapper是MyBatis-Plus提供的模板mapper，其中包含了基本的CRUD方法，泛型为操作的
实体类型
* */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 插入一条记录
     * @param entity 实体对象
     */
    int insert(User entity);
    /**
     * 根据 ID 删除
     * @param id 主键ID
     */
    int deleteById(Serializable id);
    /**
     * 根据实体(ID)删除
     * @param entity 实体对象
     * @since 3.4.4
     */
    int deleteById(User entity);
    /**
     * 根据 columnMap 条件，删除记录
     * @param columnMap 表字段 map 对象
     */
    int deleteByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
    /**
     * 根据 entity 条件，删除记录
     * @param queryWrapper 实体对象封装操作类（可以为 null,里面的 entity 用于生成 where
    语句）
     */
    int delete(@Param(Constants.WRAPPER) Wrapper<User> queryWrapper);

    /**
     * 删除（根据ID 批量删除）
     *
     * @param idList 主键ID列表(不能为 null 以及 empty)
     */

    int deleteBatchIds(@Param(Constants.COLLECTION) Collection<?> idList);

    /**
     * 根据 ID 修改
     * @param entity 实体对象
     */
    int updateById(@Param(Constants.ENTITY) User entity);
    /**
     * 根据 whereEntity 条件，更新记录
     * @param entity 实体对象 (set 条件值,可以为 null)
     * @param updateWrapper 实体对象封装操作类（可以为 null,里面的 entity 用于生成
    where 语句）
     */
    int update(@Param(Constants.ENTITY) User entity, @Param(Constants.WRAPPER)
            Wrapper<User> updateWrapper);
    /**
     * 根据 ID 查询
     * @param id 主键ID
     */
    User selectById(Serializable id);
    /**
     * 查询（根据ID 批量查询）
     * @param idList 主键ID列表(不能为 null 以及 empty)
     */
    List<User> selectBatchIds(@Param(Constants.COLLECTION) Collection<? extends
                Serializable> idList);
    /**
     * 查询（根据 columnMap 条件）
     * @param columnMap 表字段 map 对象
     */
    List<User> selectByMap(@Param(Constants.COLUMN_MAP) Map<String, Object>
                                columnMap);
    /**
     * 根据 entity 条件，查询一条记录
     * <p>查询一条记录，例如 qw.last("limit 1") 限制取一条记录, 注意：多条数据会报异常
     </p>
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    default User selectOne(@Param(Constants.WRAPPER) Wrapper<User> queryWrapper) {
        List<User> ts = this.selectList(queryWrapper);
        if (CollectionUtils.isNotEmpty(ts)) {
            if (ts.size() != 1) {
                throw ExceptionUtils.mpe("One record is expected, but the query result is multiple records");
            }
            return ts.get(0);
        }
        return null;
    }
    /**
     * 根据 Wrapper 条件，查询总记录数
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    Long selectCount(@Param(Constants.WRAPPER) Wrapper<User> queryWrapper);
    /**
     * 根据 entity 条件，查询全部记录
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    List<User> selectList(@Param(Constants.WRAPPER) Wrapper<User> queryWrapper);
    /**
     * 根据 Wrapper 条件，查询全部记录
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    List<Map<String, Object>> selectMaps(@Param(Constants.WRAPPER) Wrapper<User> queryWrapper);
    /**
     * 根据 Wrapper 条件，查询全部记录
     * <p>注意： 只返回第一个字段的值</p>
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    List<Object> selectObjs(@Param(Constants.WRAPPER) Wrapper<User> queryWrapper);
    /**
     * 根据 entity 条件，查询全部记录（并翻页）
     * @param page 分页查询条件（可以为 RowBounds.DEFAULT）
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    <P extends IPage<User>> P selectPage(P page, @Param(Constants.WRAPPER) Wrapper<User> queryWrapper);
    /**
     * 根据 Wrapper 条件，查询全部记录（并翻页）
     * @param page 分页查询条件
     * @param queryWrapper 实体对象封装操作类
     */
    <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, @Param(Constants.WRAPPER) Wrapper<User> queryWrapper);


}

