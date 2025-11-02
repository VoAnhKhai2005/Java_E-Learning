package dao;

import pojo.Member;
import java.util.List;

public interface MemberDao {
    void addMember(Member member);
    Member getMemberById(String id);
    List<Member> getAllMembers();
    void updateMember(Member member);
    void deleteMember(String id);
    void saveAll();
    void loadAll();
}
