package com.jwetherell.algorithms.data_structures;

/**
 * A splay tree is a self-adjusting binary search tree (BST) with the additional
 * property that recently accessed elements are quick to access again.
 * <p>
 *  @see <a href="https://en.wikipedia.org/wiki/Splay_tree">Splay Tree (Wikipedia)</a>
 * <br>
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public class SplayTree<T extends Comparable<T>> extends BinarySearchTree<T> {
	
	
    /**
     * {@inheritDoc}
     */
    @Override
    protected Node<T> addValue(T id) {
        Node<T> nodeToReturn = super.addValue(id);
        Node<T> nodeAdded = nodeToReturn;
        if (nodeAdded != null) {
            // Splay the new node to the root position
            while (nodeAdded.parent != null) {
                this.splay(nodeAdded);
            }
        }
        return nodeToReturn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node<T> removeValue(T value) {
        Node<T> nodeToRemove = super.removeValue(value);
        if (nodeToRemove != null && nodeToRemove.parent != null) {
            Node<T> nodeParent = nodeToRemove.parent;
            // Splay the parent node to the root position
            while (nodeParent.parent != null) {
                this.splay(nodeParent);
            }
        }
        return nodeToRemove;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(T value) {
        Node<T> node = getNode(value);
        if (node != null) {
            // Splay the new node to the root position
            while (node.parent != null) {
                this.splay(node);
            }
            return true;
        }
        return false;
    }

    /**
     * Splay the tree at the node.
     * 
     * @param node
     *            to splay at.
     */
    private void splay(Node<T> node) {
    	//Ta bort den nedan
    	boolArray = new boolean[31];
        Node<T> parent = node.parent;
        Node<T> grandParent = (parent != null) ? parent.parent : null;
        boolArray[0] = (parent != null) ? true : boolArray[0];
        
        if (parent != null && parent == root) {
        	boolArray[1] = (parent != null) ? true : boolArray[1];
        	boolArray[2] = (parent == root) ? true : boolArray[2];
            grandParent = parent.parent;
            // Zig step
            root = node;
            node.parent = null;

            if (parent!=null) {
            	boolArray[3] = (parent != null) ? true : boolArray[3];
                if (node == parent.lesser) {
               	boolArray[4] = (node == parent.lesser) ? true : boolArray[4];
                    parent.lesser = node.greater;
                    if (node.greater != null) {
                    	boolArray[5] = (node.greater != null) ? true : boolArray[5];
                        node.greater.parent = parent;
                }
                    node.greater = parent;
                    parent.parent = node;
                } else {
                	boolArray[6] = true;
                    parent.greater = node.lesser;
                    if (node.lesser != null) {
                        node.lesser.parent = parent;
                  	 boolArray[7] = (node.lesser != null) ? true : boolArray[7];
                    }
                    node.lesser = parent;
                    parent.parent = node;
                }
            }
            return;
        }

        if (parent != null && grandParent != null) {
        	boolArray[8] = (parent != null) ? true : boolArray[8];
        	boolArray[9] = (grandParent != null) ? true : boolArray[9];
            Node<T> greatGrandParent = grandParent.parent;
            if (greatGrandParent != null && greatGrandParent.lesser == grandParent) {
            	boolArray[10] = (greatGrandParent != null) ? true : boolArray[10];
            	boolArray[11] = (greatGrandParent.lesser == grandParent) ? true : boolArray[11];
            	
            	
            	
            	
            	
                greatGrandParent.lesser = node;
                node.parent = greatGrandParent;
            } else if (greatGrandParent != null && greatGrandParent.greater == grandParent) {
            	boolArray[12] = (greatGrandParent != null) ? true : boolArray[12];
            	boolArray[13] = (greatGrandParent.greater == grandParent) ? true : boolArray[13];
                greatGrandParent.greater = node;
                node.parent = greatGrandParent;
            } else {
            	boolArray[14] = true;
                // I am now root!
                root = node;
                node.parent = null;
            }

            if ((node == parent.lesser && parent == grandParent.lesser)
                || (node == parent.greater && parent == grandParent.greater)) {
                // Zig-zig step
            	
            	boolArray[15] = (node == parent.lesser) ? true : boolArray[15];
            	boolArray[16] = (parent == grandParent.lesser) ? true : boolArray[16];
            	boolArray[17] = (node == parent.greater) ? true : boolArray[17];
            	boolArray[18] = (parent == grandParent.greater) ? true : boolArray[18];
            	boolArray[19] = ((node == parent.lesser) && (parent == grandParent.lesser)) ? true : boolArray[19];
            	boolArray[20] = ((node == parent.greater) && (parent == grandParent.greater)) ? true : boolArray[20];
            	
            	
                if (node == parent.lesser) {
                	boolArray[21] = (node == parent.lesser) ? true : boolArray[21];
                    Node<T> nodeGreater = node.greater;
                    node.greater = parent;
                    parent.parent = node;

                    parent.lesser = nodeGreater;
                    if (nodeGreater != null) {
                    	boolArray[22] = (nodeGreater != null) ? true : boolArray[22];
                        nodeGreater.parent = parent;
                    }

                    Node<T> parentGreater = parent.greater;
                    parent.greater = grandParent;
                    grandParent.parent = parent;

                    grandParent.lesser = parentGreater;
                    if (parentGreater != null) {
                    	
                    	boolArray[23] = (parentGreater != null) ? true : boolArray[23];
                        parentGreater.parent = grandParent;
                        
                    }
                } else {
                	boolArray[24]= true;
                    Node<T> nodeLesser = node.lesser;
                    node.lesser = parent;
                    parent.parent = node;

                    parent.greater = nodeLesser;
                    if (nodeLesser != null) {
                    	boolArray[25] = (nodeLesser != null) ? true : boolArray[25];
                        nodeLesser.parent = parent;
                        
                    }

                    Node<T> parentLesser = parent.lesser;
                    parent.lesser = grandParent;
                    grandParent.parent = parent;

                    grandParent.greater = parentLesser;
                    if (parentLesser != null) {
                    	
                    	boolArray[26] = (parentLesser != null) ? true : boolArray[26];
                        parentLesser.parent = grandParent;
                        
                    }
                }
                return;
            }

            // Zig-zag step
            if (node == parent.lesser) {
            	boolArray[27] = (node == parent.lesser) ? true : boolArray[27];
                Node<T> nodeLesser = node.greater;
                Node<T> nodeGreater = node.lesser;

                node.greater = parent;
                parent.parent = node;

                node.lesser = grandParent;
                grandParent.parent = node;

                parent.lesser = nodeLesser;
                if (nodeLesser != null) {
               	boolArray[28] = (nodeLesser != null) ? true : boolArray[28];
                    nodeLesser.parent = parent;
                    
                }

                grandParent.greater = nodeGreater;
                if (nodeGreater != null) {
                	boolArray[29] = (nodeGreater != null) ? true : boolArray[29];
                    nodeGreater.parent = grandParent;
                    
                }
                return;
            }

            Node<T> nodeLesser = node.lesser;
            Node<T> nodeGreater = node.greater;

            node.lesser = parent;
            parent.parent = node;

            node.greater = grandParent;
            grandParent.parent = node;

            parent.greater = nodeLesser;
            if (nodeLesser != null) {
            	boolArray[30] = (nodeLesser != null) ? true : boolArray[30];
                nodeLesser.parent = parent;
                
            }

            grandParent.lesser = nodeGreater;
            if (nodeGreater != null) {
            	
            	boolArray[30] = (nodeGreater != null) ? true : boolArray[30];
                nodeGreater.parent = grandParent;
                
            }
            
            
        }
    }
}
