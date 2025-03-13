// 1281. 整数的各位积和之差

/**
 * @param {number} n
 * @return {number}
 */
var subtractProductAndSum = function(n) {
    let prod = 1, sum = 0;
    while(n){
        prod *= n % 10;
        sum += n % 10;
        n = Math.floor(n/10);
    }
    return prod - sum;
};

