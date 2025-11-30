/**
 * 骑乘设施接口，定义核心行为（Part 2 要求）
 * 用于抽象骑乘的队列管理、历史记录、运行逻辑
 */
public interface RideInterface {
    // 队列管理方法（Part 3 要求）
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue();
    void printQueue();

    // 历史记录方法（Part 4A 要求）
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();

    // 骑乘运行方法（Part 5 要求）
    void runOneCycle();
}
