package com.ming.logistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ming.logistics.mapper.ProfessionalMapper;
import com.ming.logistics.pojo.Professional;
import com.ming.logistics.service.ProfessionalService;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalServiceImpl extends ServiceImpl<ProfessionalMapper, Professional> implements ProfessionalService {
}
