## Getting Started

Welcome to the Priority Queue repository. Here is a guideline to help you get started to understand this Data Structure. In this programming part, I implement a standard Priority Queue interface in JAVA 14 using Array and Doubly Linked list and then evaluate and compare their operational performance. 

## Storing a collection of prioritized elements, a Priority Queue is an ADT characterized as follows:
In general, the elements are ordered pairs1 (k,v) with key k prioritizing value v in the priority queue.
It can store elements of any type, as long as the keys satisfy a total ordering relationship.
It supports arbitrary insertions of elements.
It allows the removal of the element that has highest priority.

## In this program :
An element with the smallest key has the highest priority.
if multiple elements have the same priority, then the removal process may arbitrary remove any of those elements.

## It supports the following MyPQ<K,V> interface :
insert(k, v): Creates an entry (element) with key k and value v in the priority queue.
min( ): Returns (but does not remove) a priority queue entry (k,v) having minimal key; returns
null if the priority queue is empty.
removeMin( ): Removes and returns an entry (k,v) having minimal key from the priority queue;
returns null if the priority queue is empty.
size( ): Returns the number of entries in the priority queue.
isEmpty( ): Returns a boolean indicating whether the priority queue is empty.


## Dependency Management

The `JAVA DEPENDENCIES` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-pack/blob/master/release-notes/v0.9.0.md#work-with-jar-files-directly).
"# Priority_Queue" 
