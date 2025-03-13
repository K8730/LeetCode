// JavaScript中创建二维数组的方法

// 1. 使用 Array 构造函数
let arr = new Array(3);
for (let i = 0; i < arr.length; i++) {
    arr[i] = new Array(3);
}
console.log(arr); // [ [ <3 empty items>, <3 empty items>, <3 empty items> ] ]

// 2. 利用数组字面量
let brr = [];
for (let i = 0; i < 3; i++) {
    brr[i] = [];
}
console.log(brr); // [ [], [], [] ]

// 3. 利用 Array.prototype.fill 方法
let crr = Array(3).fill().map(() => Array(4));
console.log(crr);

// 4. 利用 Array.from() 方法（ES6）
let drr = Array.from(Array(3), () => Array(4));
console.log(drr);