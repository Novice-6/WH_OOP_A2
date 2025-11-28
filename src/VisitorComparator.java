import java.util.Comparator;

/**
 * 游客比较器，实现 Comparator 接口（Part 4B 要求）
 * 比较逻辑：先按年龄升序，年龄相同则按会员类型字典序
 */
public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 第一排序条件：年龄
        int ageCompare = Integer.compare(v1.getAge(), v2.getAge());
        if (ageCompare != 0) {
            return ageCompare;
        }
        // 第二排序条件：会员类型（字典序）
        return v1.getMembershipType().compareTo(v2.getMembershipType());
    }
}
