package com.zisheng.Service.Impls;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zisheng.Mapper.EBookMapper;
import com.zisheng.Pojo.DTO.EbookDTO;
import com.zisheng.Pojo.Entity.Ebook;
import com.zisheng.Pojo.VO.EbookVO;
import com.zisheng.Service.EBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EBookServiceImpl extends ServiceImpl<EBookMapper, Ebook> implements EBookService {
    private static final Logger log = LoggerFactory.getLogger(EBookServiceImpl.class);
    @Resource
    private EBookMapper eBookMapper;

    /**
     * 根据名称模糊查询
     * @param ebookDTO
     * @return
     */
    @Override
    public List<EbookVO> selectByName(EbookDTO ebookDTO) {
        LambdaQueryWrapper<Ebook> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper
                .like(StrUtil.isNotEmpty(ebookDTO.getName()),Ebook::getName,ebookDTO.getName());
        List<Ebook> ebooks = eBookMapper.selectList(lambdaQueryWrapper);
        return ebooks.stream().map(ebook -> {
            EbookVO ebookVO = new EbookVO();
            BeanUtils.copyProperties(ebook, ebookVO);
            return ebookVO;
        }).collect(Collectors.toList());
    }
}
