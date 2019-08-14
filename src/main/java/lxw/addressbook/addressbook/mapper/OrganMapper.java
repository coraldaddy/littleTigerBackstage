package lxw.addressbook.addressbook.mapper;

import java.util.List;

import lxw.addressbook.addressbook.domain.Organ;
import lxw.addressbook.addressbook.domain.OrganExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrganMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Organ record);

    int insertSelective(Organ record);

    List<Organ> selectByExample(OrganExample example);

    Organ selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Organ record, @Param("example") OrganExample example);

    int updateByExample(@Param("record") Organ record, @Param("example") OrganExample example);

    int updateByPrimaryKeySelective(Organ record);

    int updateByPrimaryKey(Organ record);
}