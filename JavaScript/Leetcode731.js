// 731. 我的日程安排表 II

// 实现一个程序来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。

// 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生 三重预订。

var MyCalendarTwo = function () {
    this.events = [];
    this.overlaps = [];
};

/** 
 * @param {number} startTime 
 * @param {number} endTime
 * @return {boolean}
 */
MyCalendarTwo.prototype.book = function (startTime, endTime) {
    // 如果和 overlaps 重叠，直接失败
    for (const arr of this.overlaps) {
        let left = arr[0], right = arr[1];
        if (left < endTime && startTime < right) {
            return false;
        }
    }

    // 如果和 events 重叠，同时添加到 overlaps 和 events中
    for (const arr of this.events) {
        let left = arr[0], right = arr[1];
        if (left < endTime && startTime < right) {
            // 计算重叠的区域
            this.overlaps.push([Math.max(left, startTime), Math.min(right, endTime)]);
        }
    }
    // 预定正常添加
    this.events.push([startTime, endTime]);
    return true;
};

