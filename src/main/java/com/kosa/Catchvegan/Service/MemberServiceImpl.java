package com.kosa.Catchvegan.Service;

import com.kosa.Catchvegan.DTO.ManagerDTO;
import com.kosa.Catchvegan.DTO.MemberDTO;
import com.kosa.Catchvegan.DTO.ReserveDTO;
import com.kosa.Catchvegan.Mapper.ManagerMapper;
import com.kosa.Catchvegan.Mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private BCryptPasswordEncoder pe;


    //Member
    @Override
    public List<MemberDTO> findAllMembers(){
        return memberMapper.findAllMembers();
    }
    @Override
    @Transactional
    public MemberDTO createMember(MemberDTO member){
        String pw = member.getPassword();
        member.setPassword(pe.encode(pw));
        memberMapper.createMember(member);
        memberMapper.userRole(member.getMemberIdx());
        return null;
    }

    @Override
    public boolean getId(String id){
        return memberMapper.idGet(id) == null? false : true;
    }

    @Override
    public MemberDTO getUserByIdAndPassword(String id) {
        return memberMapper.getUserByIdAndPassword(id);
    }

    @Override
    public void memberUpdate(MemberDTO memberDTO) {
        String pw = memberDTO.getPassword();
        memberDTO.setPassword(pe.encode(pw));
        memberMapper.memberUpdate(memberDTO);
    }

    @Override
    public boolean findByPhone(String phone) {
        return memberMapper.findByPhone(phone) == null? false : true;
    }

    @Override
    public boolean idFindByPhone(String id) {
        return memberMapper.idFindByPhone(id) == null? false : true;
    }

    @Override
    public void passwordUpdate(MemberDTO memberDTO) {
        String pw = memberDTO.getPassword();
        memberDTO.setPassword(pe.encode(pw));
        memberMapper.passwordUpdate(memberDTO);
    }

    @Override
    public String idFind(String phone) {
        return memberMapper.idFindByPhone(phone).getId();
    }


}
