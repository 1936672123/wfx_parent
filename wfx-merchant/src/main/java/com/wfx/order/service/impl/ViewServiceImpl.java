package com.wfx.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wfx.entity.View;
import com.wfx.order.mapper.ViewMapper;
import com.wfx.order.service.IViewService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-10-26
 */
@Service
public class ViewServiceImpl extends ServiceImpl<ViewMapper, View> implements IViewService {

}
