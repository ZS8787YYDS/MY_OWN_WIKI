package com.zisheng.Controller;

import com.zisheng.Pojo.DTO.EbookDTO;
import com.zisheng.Pojo.VO.EbookVO;
import com.zisheng.ResponseResult.Result;
import com.zisheng.Service.EBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
@Api(tags = "电子书相关接口")
@Slf4j
public class EBookController {
    @Resource
    private EBookService eBookService;

    //    /**
//     * 电子书查询接口,非模糊查询
//     * @return
//     */
//    @GetMapping("/list")
//    @ApiOperation(value = "查询所有电子书")
//    public Result<List<Ebook>> selectALl()
//    {
//        List<Ebook> list = eBookService.list();
//        return Result.success(list);
//    }

    /**
     * 根据名称模糊查询
     * @param ebookDTO
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "查询所有电子书")
    public Result<List<EbookVO>> selectByName(EbookDTO ebookDTO) {
        log.info("接收到的数据为：{}",ebookDTO);
        List<EbookVO> list = eBookService.selectByName(ebookDTO);
        return Result.success(list);
    }
}
