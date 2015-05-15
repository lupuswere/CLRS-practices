# CLRS-practices

_This is a repository for myself to store my solutions for CLRS problems and implementations of algorithms in CLRS._
_For each class, there is a unit test class._

## Packages
* net.lilifei.basic
    * Search
    * Sort
    * Interval (built for fuzzy sort)
* net.lilifei.dataStructure
    * D-naryHeap
    * Heap
    * LinkedListNode
    * YoungTableau (not completed)
* net.lilifei.random
    * RandomAlgorithm
    
## Search for code

Currently, search for number or algorithm name.

For example, for this code block:

```java
/**
 * 6.2 : MAX-HEAPIFY
 *
 * @param A        : the heap
 * @param i        : the index of the root of the heap
 * @param heapSize : the size of the heap
 */
public static void maxHeapify(int[] A, int i, int heapSize) {
    int l = left(i);
    int r = right(i);
    int largest = l;
    if (l < heapSize && A[l] > A[i]) {
        largest = l;
    } else {
        largest = i;
    }
    if (r < heapSize && A[r] > A[largest]) {
        largest = r;
    }
    if (largest != i) {
        int tmp = A[largest];
        A[largest] = A[i];
        A[i] = tmp;
        maxHeapify(A, largest, heapSize);
    }
}
```

You can search for 6.2 or MAX-HEAPIFY as it is in the book.

## Current Progress
Chapter 8.3