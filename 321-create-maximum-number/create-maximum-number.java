class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
       int[] res = null;
        for (int i = 0; i <= k; i++) {
            if (i <= nums1.length && k - i <= nums2.length) {
                int[] max1 = getMaxSub(nums1, i);
                int[] max2 = getMaxSub(nums2, k - i);
                if (max1 == null || max2 == null) continue;
                int[] tmp = mergeMax(max1, max2);
                if (compareArr(tmp, res)) {
                    res = tmp;
                }
            }
        }
    return res;
}

    private boolean compareArr(int[] tmp, int[] res) {
        if(res == null) return true;
        for (int i = 0; i < res.length; i++) {
            if (tmp[i] < res[i]) return false;
            if (tmp[i] > res[i]) return true;
        }
        return true;
    }

    public int[] mergeMax(int[] max1, int[] max2) {
        int i = 0, j = 0, id = 0;
        int size1 = max1.length;
        int size2 = max2.length;
        int[] res = new int[size1 + size2];
        while (size1 > 0 && size2 > 0 && i < size1 && j < size2) {
            if (max1[i] > max2[j]) {
                res[id++] = max1[i++];
            } else if (max1[i] == (max2[j])) {
                if (i + 1 < size1 && j + 1 < size2) {
                    if (max1[i + 1] == max2[j + 1]) {
                        if (max1[i + 1] >= max1[i]) {
                            int m = i + 2, n = j + 2;
                            boolean goToMax1 = true;
                            boolean isTracking = false;
                            while (m < size1 && n < size2) {
                                if (max1[m] != max2[n]) {
                                    if (max1[m] > max2[n]) {
                                        isTracking = true;
                                    } else {
                                        isTracking = true;
                                        goToMax1 = false;
                                    }
                                    break;
                                }
                                m++;
                                n++;
                            }
                            if (isTracking) {
                                if (goToMax1) {
                                    res[id++] = max1[i++];
                                } else {
                                    res[id++] = max2[j++];
                                }
                            } else {
                                if (m >= size1 && n < size2) {
                                    if (max2[--n] > max1[i]) {
                                        res[id++] = max2[j++];
                                    } else if (max2[--n] == max1[i]) {
                                        res[id++] = max2[j++];
                                    } else {
                                        res[id++] = max1[i++];
                                    }

                                } else if (m < size1) {
                                    if (max1[--m] > max2[j]) {
                                        res[id++] = max1[i++];
                                    } else if (max2[--n] == max1[i]) {
                                        res[id++] = max1[i++];
                                    } else {
                                        res[id++] = max2[j++];
                                    }
                                } else {
                                    res[id++] = max1[i++];
                                    res[id++] = max2[j++];
                                }
                            }
                        } else {
                            res[id++] = max1[i++];
                            res[id++] = max2[j++];
                        }
                    } else if (max1[i + 1] > max2[j] && max1[i + 1] > max2[j + 1]) {
                        res[id++] = max1[i++]; // [6, 8] vs [6, 7]
                    } else if (max2[j + 1] > max1[i] && max2[j + 1] > max1[i + 1]) {
                        res[id++] = max2[j++]; // [6, 7] vs [6, 8]
                    } else {
                        res[id++] = max1[i++];
                        res[id++] = max2[j++];
                    }
                } else if (i + 1 >= size1 && j + 1 >= size2) {
                    if (max1[i] > max2[j]) {
                        res[id++] = max1[i++];
                        res[id++] = max2[j++];
                    } else {
                        res[id++] = max2[j++];
                        res[id++] = max1[i++];
                    }
                } else if (i + 1 < size1) {
                    if (max1[i + 1] >= max2[j]) {
                        res[id++] = max1[i++];
                    } else {
                        res[id++] = max2[j++];
                    }
                } else {
                    if (max2[j + 1] >= max1[i]) {
                        // [1, 3] vs [1]
                        res[id++] = max2[j++];
                    } else {
                        res[id++] = max1[i++];
                    }
                }
            } else {
                res[id++] = max2[j++];
            }
        }
        if (size1 == 0 || i >= size1) {
            for (int k = j; k < size2; k++) {
                res[id++] = max2[k];
            }
        } else {
            for (int k = i; k < size1; k++) {
                res[id++] = max1[k];
            }
        }
        return res;
    }

    private int[] getMaxSub(int[] nums, int k) {
        if (k == 0) return new int[]{};
        if (k > nums.length) return null;
        int[] res = new int[k];
        res[0] = nums[0];
        int last = nums.length - 1;
        int cnt = 1;
        // 5 6 4 2 3 6 k = 3
        // 5 6  and k = 1
        for (int i = 1; i <= last; i++) {
            while (cnt > 0 && res[cnt - 1] < nums[i] && last - i >= k - cnt) {
                cnt--;
            }
            if (cnt < k) {
                res[cnt] = nums[i];
                cnt++;
            }
        }
        return res; 
    }
}