// LRU 缓存
// 最近最少使用，根据记录数据的使用顺序来决定哪些数据应该被淘汰
// 实现 LRUCache 类
// get 和 put方法

/**
 * @param {number} capacity
 */
var LRUCache = function (capacity) {
    this.capacity = capacity; // 容量
    this.cache = new Map(); // 存储数据
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function (key) {
    if (!this.cache.has(key)) {
        return -1; // 如果缓存中没有，返回 -1
    }

    // 如果有，先删除，再重新插入，表示最近使用过
    let value = this.cache.get(key);
    this.cache.delete(key);
    this.cache.set(key, value);
    return value; // 返回对应的值
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function (key, value) {
    if (this.cache.has(key)) {
        // 如果缓存中有这个 key，先删除
        this.cache.delete(key);
    } else if (this.cache.size >= this.capacity) {
        // 如果缓存已满，删除最久未使用的元素（最早插入的键）
        let firstKey = this.cache.keys().next().value;
        this.cache.delete(firstKey);

        // ====================================================
        // 在 JavaScript 中，Map 对象按照插入顺序保存键值对。
        // 也就是说，Map 中的第一个键值对是最早插入的，而最后一个键值对是最新插入的。
        // .keys() 方法获取一个包含 Map 中所有键的迭代器，然后调用 next() 方法获取迭代器的第一个对象
        // 结果对象的 value 属性就是 Map 中第一个键，即最早插入的键。
        // ==================================================== 
        // JS 迭代器
        // 迭代器是一种特殊的对象，它实现了 Iterator 协议
        // 即具有一个 next 方法，该方法返回一个对象，该对象包含两个属性：value 和 done。
        // value：迭代器返回的当前元素的值
        // done：一个布尔值，表示迭代是否已经完成。true 表示已完成
        // ====================================================
    }
    // 在尾部插入新的 key-value 对
    this.cache.set(key, value);
};

/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */