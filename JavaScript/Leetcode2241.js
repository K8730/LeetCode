// 2241. 设计一个 ATM 机器

const DENOMINATIONS = [20, 50, 100, 200, 500];
const KINDS = DENOMINATIONS.length;

var ATM = function () {
    this.banknotes = Array(KINDS).fill(0);
};

/** 
 * @param {number[]} banknotesCount
 * @return {void}
 */
ATM.prototype.deposit = function (banknotesCount) {
    for (let i = 0; i < KINDS; i++) {
        this.banknotes[i] += banknotesCount[i];
    }
};

/** 
 * @param {number} amount
 * @return {number[]}
 */
ATM.prototype.withdraw = function (amount) {
    const ans = Array(KINDS).fill(0);
    let curAmount = amount;

    for (let i = KINDS - 1; i >= 0; i--) {
        ans[i] = Math.min(this.banknotes[i], Math.floor(curAmount / DENOMINATIONS[i]));
        curAmount -= ans[i] * DENOMINATIONS[i];
    }

    // 无法恰好取得 amount
    if (curAmount > 0) {
        return [-1];
    }

    // 取钱
    for (let i = 0; i < KINDS; i++) {
        this.banknotes[i] -= ans[i];
    }

    return ans;
};

/** 
 * Your ATM object will be instantiated and called as such:
 * var obj = new ATM()
 * obj.deposit(banknotesCount)
 * var param_2 = obj.withdraw(amount)
 */