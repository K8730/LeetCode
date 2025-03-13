// 729. 我的日程安排表 I

// 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。


var MyCalendar = function () {
    this.events = [];
};

/** 
 * @param {number} startTime 
 * @param {number} endTime
 * @return {boolean}
 */
MyCalendar.prototype.book = function (startTime, endTime) {
    for (const arr of this.events) {
        let l = arr[0];
        let r = arr[1];
        if (l < endTime && startTime < r) {
            return false;
        }
    }
    this.events.push([startTime, endTime]);
    return true;
};


// 维护 events数组的有序性
var MyCalendar = function () {
    this.events = [];
};

MyCalendar.prototype.book = function (startTime, endTime) {
    // 找到第一个开始时间大于等于 endTime 的区间
    for (let i = 0; i < this.events.length; i++) {
        let [s, e] = this.events[i];
        if (s >= endTime) {
            // 检查是否可以插入当前区间
            if (i === 0 || this.events[i - 1][1] <= startTime) {
                // 插入当前区间
                this.events.splice(i, 0, [startTime, endTime]);
                return true;
            }
            return false;
        }
    }

    // 如果没有找到合适的位置，直接插入到末尾
    if (this.events.length === 0 || this.events[this.events.length - 1][1] <= startTime) {
        this.events.push([startTime, endTime]);
        return true;
    }
    return false;
};