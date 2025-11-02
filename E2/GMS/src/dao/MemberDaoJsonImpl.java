package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import util.LocalDateAdapter;
import java.time.LocalDate;
import pojo.Member;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoJsonImpl implements MemberDao {
    private static final String FILE_PATH = "data/members.json";
    private List<Member> members;
    private Gson gson;

    public MemberDaoJsonImpl() {
        this.members = new ArrayList<>();
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        loadAll();
    }

    @Override
    public void addMember(Member member) {
        members.add(member);
        saveAll();
    }

    @Override
    public Member getMemberById(String id) {
        return members.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Member> getAllMembers() {
        return new ArrayList<>(members);
    }

    @Override
    public void updateMember(Member member) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId().equals(member.getId())) {
                members.set(i, member);
                saveAll();
                return;
            }
        }
    }

    @Override
    public void deleteMember(String id) {
        members.removeIf(m -> m.getId().equals(id));
        saveAll();
    }

    @Override
    public void saveAll() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(members, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadAll() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<List<Member>>(){}.getType();
            members = gson.fromJson(reader, listType);
            if (members == null) {
                members = new ArrayList<>();
            }
        } catch (IOException e) {
            members = new ArrayList<>();
        }
    }
}
