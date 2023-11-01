package com.zisheng.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zisheng.Pojo.DTO.EbookDTO;
import com.zisheng.Pojo.Entity.Ebook;
import com.zisheng.Pojo.VO.EbookVO;

import java.util.List;

public interface EBookService extends IService<Ebook>{
    /**
     * 根据名称模糊查询接口
     * @param ebookDTO
     * @return
     */
    List<EbookVO> selectByName(EbookDTO ebookDTO);
}
