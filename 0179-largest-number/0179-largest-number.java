class Solution {
    public String largestNumber(int[] nums) {
        String[] s = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));
        if (s[0].equals("0"))
            return "0";
        return String.join("", s);
    }
}