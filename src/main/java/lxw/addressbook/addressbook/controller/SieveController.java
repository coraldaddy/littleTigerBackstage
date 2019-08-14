package lxw.addressbook.addressbook.controller;

import lombok.extern.slf4j.Slf4j;
import lxw.addressbook.addressbook.common.RestfulResponse;
import lxw.addressbook.addressbook.domain.Sieve;
import lxw.addressbook.addressbook.model.request.SelectUserByOPenIdRequest;
import lxw.addressbook.addressbook.model.responce.ChickRankingListResponse;
import lxw.addressbook.addressbook.service.SieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "sieve")
public class SieveController {

    @Autowired private SieveService sieveService;

    /**
     * 功能描述: 查询分数
     * @auther: lxw
     * @date: 2019/2/2 15:08
     */
    @RequestMapping(value = "/selectHighest",method = RequestMethod.POST)
    public RestfulResponse selectHighest(@RequestBody SelectUserByOPenIdRequest selectUserByOPenIdRequest){
        return sieveService.selectByOpenId(selectUserByOPenIdRequest.getOpenId());
    }

    /**
     * 功能描述: 修改数据
     * @auther: lxw
     * @date: 2019/2/2 15:09
     */
    @RequestMapping(value = "/refreshRecord",method = RequestMethod.POST)
    public RestfulResponse refreshRecord(@RequestBody Sieve sieve){
        return sieveService.updateSieveByUserId(sieve);
    }

    @RequestMapping(value = "/chickRankingList",method = RequestMethod.POST)
    public RestfulResponse chickRankingList(){
        return sieveService.chickRankingList();
    }

}
