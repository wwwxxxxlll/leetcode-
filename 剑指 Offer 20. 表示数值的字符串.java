class Solution {
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap<>() {
                    {
                        put(0, 0);
                        put(1, 1);
                        put(2, 2);
                        put(3, 4);
                    }
                },
                new HashMap<>() {
                    {
                        put(2, 2);
                        put(3, 4);
                    }
                },
                new HashMap<>() {
                    {
                        put(2, 2);
                        put(3, 3);
                        put(4, 6);
                        put(0, 9);
                    }
                },
                new HashMap<>() {
                    {
                        put(2, 5);
                        put(4, 6);
                        put(0, 9);
                    }
                },
                new HashMap<>() {
                    {
                        put(2, 5);
                    }
                },
                new HashMap<>() {
                    {
                        put(2, 5);
                        put(4, 6);
                        put(0, 9);
                    }
                },
                new HashMap<>() {
                    {
                        put(1, 7);
                        put(2, 8);
                    }
                },
                new HashMap<>() {
                    {
                        put(2, 8);
                    }
                },
                new HashMap<>() {
                    {
                        put(2, 8);
                        put(0, 9);
                    }
                },
                new HashMap<>() {
                    {
                        put(0, 9);
                    }
                },
        };
        char[] chs = s.toCharArray();
        int stateId = 0; // 初始状态视为 0 ，即「开始空格」
        for (char c : chs) {
            int typeId = typeOf(c);
            if (!states[stateId].containsKey(typeId))
                return false; // 无状态对应的类型
            stateId = (int) states[stateId].get(typeId); // 状态转移
        }
        return stateId == 2 || stateId == 3 || stateId == 5 || stateId == 8 || stateId == 9;
    }

    private int typeOf(char c) {
        if (c == ' ')
            return 0;
        else if (c == '+' || c == '-')
            return 1;
        else if (c - '0' >= 0 && c - '0' <= 9)
            return 2;
        else if (c == '.')
            return 3;
        else if (c == 'e' || c == 'E')
            return 4;
        else
            return -1;
    }
}