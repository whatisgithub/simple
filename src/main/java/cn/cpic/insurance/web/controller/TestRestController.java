package cn.cpic.insurance.web.controller;

import cn.cpic.insurance.web.controller.vo.UserVo;
import cn.cpic.insurance.web.controller.vo.ValidateVo;
import cn.cpic.insurance.web.util.WebUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequestMapping("/test")
@Slf4j
@Api(tags = "1.1")
public class TestRestController {

    @GetMapping("/query/{id}")
    @ApiOperation("查询用户")
    public UserVo test(@RequestParam("id") Integer id){
        return new UserVo();
    }

    @PostMapping("/user")
    @ApiOperation(value = "添加用户")
    public UserVo post(@RequestBody UserVo user) {
        return user;
    }

    @PostMapping("/exception")
    public UserVo testException(@Valid @RequestBody ValidateVo vvo, BindingResult br){
        if(br.hasErrors()) {
            log.info(WebUtil.handlerErrmsg(br));
        }
        log.info("开始进行跑出来一个异常");
        if(1==1) throw new RuntimeException();
        log.info("异常没进来");
        return new UserVo();
    }
}
