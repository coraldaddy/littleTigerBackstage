package lxw.addressbook.addressbook.service;

import lxw.addressbook.addressbook.common.RestfulResponse;
import lxw.addressbook.addressbook.common.StatusCode;
import lxw.addressbook.addressbook.domain.Sieve;
import lxw.addressbook.addressbook.mapper.SieveMapper;
import lxw.addressbook.addressbook.model.responce.ChickRankingListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SieveService {

    @Autowired private SieveMapper sieveMapper;

    public RestfulResponse selectByOpenId(String openId) {
        List<Sieve> sieveList = sieveMapper.selectByOpenId(openId);
        if(sieveList!=null&&sieveList.size()==1){
            return RestfulResponse.getRestfulResponse(StatusCode.SELECT_SUCCESS,sieveList.get(0));
        }
        return RestfulResponse.getRestfulResponse(StatusCode.SELECT_FALL);
    }

    public RestfulResponse updateSieveByUserId(Sieve sieve) {
        int i = sieveMapper.updateByUserId(sieve);
        if(i==1) {
            return RestfulResponse.getRestfulResponse(StatusCode.UPDATE_SUCCESS);
        }else{
            return RestfulResponse.getRestfulResponse(StatusCode.UPDATE_FALL);
        }
    }

    public RestfulResponse chickRankingList() {
        List<ChickRankingListResponse> chickRankingListResponses = sieveMapper.chickRankingList();
        return RestfulResponse.getRestfulResponse(StatusCode.SELECT_SUCCESS,chickRankingListResponses);
    }
}
