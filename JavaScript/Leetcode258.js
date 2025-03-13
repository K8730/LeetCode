// 258. 各位相加
/**
 * @param {number} num
 * @return {number}
 */
var addDigits = function(num) {
    if(num < 10){
        return num;
    }
    return addDigits(Math.floor(num / 10) + num % 10);
};

// 数学
var addDigits  = function(num){
    return (num - 1) % 9 + 1;
}