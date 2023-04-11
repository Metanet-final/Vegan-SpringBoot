package com.kosa.Catchvegan.Mapper;

import com.kosa.Catchvegan.DTO.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper {
    public List<MemberDTO> findAllMembers();
    public Long createMember(MemberDTO member);

    public void userRole(@Param("memberidx") Integer memberidx);

    public MemberDTO getUserByIdAndPassword(@Param("id") String id);
    public MemberDTO idGet(@Param("id") String id);
}
