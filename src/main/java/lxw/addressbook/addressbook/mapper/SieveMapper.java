package lxw.addressbook.addressbook.mapper;

import java.util.List;

import lxw.addressbook.addressbook.domain.Sieve;
import lxw.addressbook.addressbook.domain.SieveExample;
import lxw.addressbook.addressbook.model.responce.ChickRankingListResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SieveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sieve record);

    int insertSelective(Sieve record);

    List<Sieve> selectByExample(SieveExample example);

    Sieve selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sieve record, @Param("example") SieveExample example);

    int updateByExample(@Param("record") Sieve record, @Param("example") SieveExample example);

    int updateByPrimaryKeySelective(Sieve record);

    int updateByPrimaryKey(Sieve record);

    List<Sieve> selectByOpenId(String openId);

    int updateByUserId(Sieve sieve);

    List<ChickRankingListResponse> chickRankingList();
}