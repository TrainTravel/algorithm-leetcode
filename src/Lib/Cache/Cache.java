package Lib.Cache;

/**
 * Definition of Cache.
 * Worked as double linked list.
 */
public class Cache {
    public int key;     // cache key
    public int val;     // value store in cache
    public Cache previous;      // previous cache block pointer
    public Cache next;          // next cache block pointer
}
