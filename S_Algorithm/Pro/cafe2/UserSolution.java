package Pro.cafe2;

import java.util.*;

class UserSolution {
    static final int MAX_ORDER = 50005;
    static final int MAX_BEV = 11;

    class Order implements Comparable<Order> {
        int mID, orderTime, totalRemaining;
        int[] bevNeeded = new int[MAX_BEV];    // 아직 못 받은 음료 개수
        int[] bevAllocated = new int[MAX_BEV]; // 이미 받은 음료 개수
        boolean active;

        public void init(int id, int time, int M, int[] beverages) {
            this.mID = id;
            this.orderTime = time;
            this.totalRemaining = M;
            this.active = true;
            for (int i = 0; i < MAX_BEV; i++) {
                bevNeeded[i] = 0;
                bevAllocated[i] = 0;
            }
            for (int i = 0; i < M; i++) {
                bevNeeded[beverages[i]]++;
            }
        }

        @Override
        public int compareTo(Order o) {
            // 1. 남은 음료 개수 내림차순
            if (this.totalRemaining != o.totalRemaining) {
                return Integer.compare(o.totalRemaining, this.totalRemaining);
            }
            // 2. 주문 시간 오름차순 (먼저 온 주문)
            if (this.orderTime != o.orderTime) {
                return Integer.compare(this.orderTime, o.orderTime);
            }
            // 3. ID 비교 (TreeSet에서 객체 유실 방지)
            return Integer.compare(this.mID, o.mID);
        }
    }

    Order[] orderPool = new Order[MAX_ORDER];
    Map<Integer, Integer> idToIndex = new HashMap<>();
    ArrayDeque<Integer>[] waitingQueues = new ArrayDeque[MAX_BEV];
    TreeSet<Order> activeOrders = new TreeSet<>();
    int orderIdx, activeOrderCount, N;

    public void init(int N) {
        this.N = N;
        idToIndex.clear();
        activeOrders.clear();
        orderIdx = 0;
        activeOrderCount = 0;
        for (int i = 1; i <= 10; i++) {
            if (waitingQueues[i] == null) waitingQueues[i] = new ArrayDeque<>();
            waitingQueues[i].clear();
        }
        for (int i = 0; i < MAX_ORDER; i++) {
            if (orderPool[i] == null) orderPool[i] = new Order();
        }
    }

    public int order(int mID, int M, int mBeverages[]) {
        int idx = orderIdx++;
        orderPool[idx].init(mID, idx, M, mBeverages);
        idToIndex.put(mID, idx);
        activeOrderCount++;
        activeOrders.add(orderPool[idx]);

        // 중복 음료 개수만큼 대기열에 추가
        for (int i = 0; i < M; i++) {
            waitingQueues[mBeverages[i]].addLast(idx);
        }
        return activeOrderCount;
    }

    public int supply(int mBeverage) {
        return allocate(mBeverage);
    }

    // 실제 음료 배정 로직 (supply와 cancel-reassign 공용)
    private int allocate(int bev) {
        while (!waitingQueues[bev].isEmpty()) {
            int idx = waitingQueues[bev].pollFirst();
            Order o = orderPool[idx];

            // 취소된 주문이거나 이미 해당 음료를 충분히 받은 경우 건너뜀
            if (!o.active || o.bevNeeded[bev] == 0) continue;

            // 상태 업데이트를 위해 TreeSet에서 일시 제거
            activeOrders.remove(o);
            o.bevNeeded[bev]--;
            o.bevAllocated[bev]++;
            o.totalRemaining--;

            if (o.totalRemaining == 0) {
                o.active = false;
                activeOrderCount--;
                // 완료된 주문은 다시 넣지 않음
            } else {
                activeOrders.add(o);
            }
            return o.mID;
        }
        return -1; // 배정될 주문이 없음 (버려짐)
    }

    public int cancel(int mID) {
        Integer idx = idToIndex.get(mID);
        if (idx == null) return -1;
        Order o = orderPool[idx];

        if (!o.active) {
            // 완료된 상태면 0, 이미 취소된 상태면 -1
            return (o.totalRemaining == 0) ? 0 : -1;
        }

        int remainingBeforeCancel = o.totalRemaining;
        activeOrders.remove(o);
        o.active = false;
        activeOrderCount--;

        // 이미 이 주문에 배치되었던 음료들을 다른 사람에게 재배치
        for (int b = 1; b <= 10; b++) {
            while (o.bevAllocated[b] > 0) {
                o.bevAllocated[b]--;
                allocate(b); // 재배치 시에도 supply와 동일한 우선순위 적용
            }
        }
        return remainingBeforeCancel;
    }

    public int getStatus(int mID) {
        Integer idx = idToIndex.get(mID);
        if (idx == null) return -1;
        Order o = orderPool[idx];
        if (!o.active) return (o.totalRemaining == 0) ? 0 : -1;
        return o.totalRemaining;
    }

    public Solution.RESULT hurry() {
        Solution.RESULT res = new Solution.RESULT();
        int count = 0;
        // TreeSet을 순회하면 정렬 조건(개수 DESC, 시간 ASC)대로 나옴
        for (Order o : activeOrders) {
            if (count == 5) break;
            res.IDs[count++] = o.mID;
        }
        res.cnt = count;
        return res;
    }
}

