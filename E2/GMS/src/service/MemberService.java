package service;

import pojo.Member;
import repository.MemberRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MemberService {
    private MemberRepository memberRepository;

    public MemberService() {
        this.memberRepository = new MemberRepository();
    }

    public void addMember(String id, String name, String email, String password, String subscriptionId, LocalDate joinDate, LocalDate expiryDate, boolean isActive) {
        Member member = new Member(id, name, email, password, subscriptionId, joinDate, expiryDate, isActive);
        memberRepository.addMember(member);
    }

    public Member getMemberById(String id) {
        return memberRepository.getMemberById(id);
    }

    public List<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }

    public void updateMember(Member member) {
        memberRepository.updateMember(member);
    }

    public void deleteMember(String id) {
        memberRepository.deleteMember(id);
    }

    public List<Member> getActiveMembers() {
        return memberRepository.getAllMembers().stream()
                .filter(Member::isActive)
                .collect(Collectors.toList());
    }

    public List<Member> getExpiredMembers() {
        return memberRepository.getAllMembers().stream()
                .filter(m -> !m.isActive() || m.getExpiryDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }

    public int getActiveMemberCount() {
        return getActiveMembers().size();
    }

    public int getExpiredMemberCount() {
        return getExpiredMembers().size();
    }
}
