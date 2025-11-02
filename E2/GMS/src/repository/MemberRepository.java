package repository;

import dao.MemberDao;
import dao.MemberDaoJsonImpl;
import pojo.Member;
import java.util.List;

public class MemberRepository {
    private MemberDao memberDao;

    public MemberRepository() {
        this.memberDao = new MemberDaoJsonImpl();
    }

    public void addMember(Member member) {
        memberDao.addMember(member);
    }

    public Member getMemberById(String id) {
        return memberDao.getMemberById(id);
    }

    public List<Member> getAllMembers() {
        return memberDao.getAllMembers();
    }

    public void updateMember(Member member) {
        memberDao.updateMember(member);
    }

    public void deleteMember(String id) {
        memberDao.deleteMember(id);
    }

    public void saveAll() {
        memberDao.saveAll();
    }

    public void loadAll() {
        memberDao.loadAll();
    }
}
