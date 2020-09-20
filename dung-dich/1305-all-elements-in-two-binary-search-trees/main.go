package main

func main() {
  getAllElements(nil, nil)
}


type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

func getAllElements(root1 *TreeNode, root2 *TreeNode) []int {
    if root1 == nil && root2 == nil {
        return nil
    }
    var list1 []int
    if root1 != nil {
        list1 = preOrder(root1, list1)
    }
    
    var list2 []int
    if root2 != nil {
        list2 = preOrder(root2, list2)
    }
    
    if len(list1) == 0 {
        return list2
    }
    if len(list2) == 0 {
        return list1
    }
    
    var list3 []int
    for i, j := 0, 0;; {
        var elem1 int
        if len(list1) > i {
            elem1 = list1[i]
        } else {
            if len(list2) > j {
                list3 = append(list3, list2[j:]...)
                break
            }
        }
        
        var elem2 int
        if len(list2) > j {
            elem2 = list2[j]
        } else {
            if len(list1) > i {
                list3 = append(list3, list1[i:]...)
                break
            }
        }
        
        if elem1 < elem2 {
            list3 = append(list3, elem1)
            i++
        } else {
            list3 = append(list3, elem2)
            j++
        }
    }
    return list3
}

func preOrder(node *TreeNode, list []int) []int {
    if node.Left != nil {
        list = preOrder(node.Left, list)
    }
    list = append(list, node.Val)
    if node.Right != nil {
        return preOrder(node.Right, list)
    }
    return list
}
