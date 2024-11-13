# 代码随想录算法训练营第一天| 704.Binary Search
## 1. Binary Search
* 思路：考虑两种情况：区间为左闭右闭以及区间为左闭右开
1. 区间为左闭右闭的情况[left, right],当中间值大于target的时候，需要改变右端点，又因为右区间为闭区间，middle不可以取到，所以执行right = middle -1;
当中间值小于target时，需要改变左端点，同上缘由，执行left = middle + 1;
![image](https://github.com/user-attachments/assets/18beb37f-a637-4ce9-b231-efcef0e55658)

2. 区间为左闭右开的情况[left, right),当中间值大于target时，需要改变右端点，因为是开区间，可以直接执行right = middle(因为middle不会取到)
当中间值大于target时，需要改变左端点，但是不可以取到middle，所以left = middle + 1;
![Uploading image.png…]()
