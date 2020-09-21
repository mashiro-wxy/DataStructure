package basic_class;

import java.util.LinkedList;

public class suanfashejiti {
    public static int count(LList list, Object X){
        //统计并返回线性表list中值为X的元素个数
        int t = 0;
        for(int i = 0; i < list.size(); i++){
            if (list.value(i+1).equals(X)){
                t++;
            }
        }
        return t;
    }

    public static int minmum(LList list){
        //求出并返回参数线性表list中所有元素的最小值
        if (list.size() == 0) return 0;
        int min = list.value(1);
        for (int i = 2; i < list.size(); i++){
            int x = list.value(i);
            if (x < min) min = t;
        }
        return min;
    }

    public void revef(LList list){
        //将线性表LList中所有的元素按照原来的次序倒序排列
        int n = list.size();
        for (int i = 1; i <= n/2; i++){
            Object x = list.value(i);
            list.modify(list.value(n + 1 - i), i);
            list.modify(x, n + 1 - i);
        }
    }

    public static void delallX(LList list, Object X){
        //从线性表LList中删除与X值相同的所有元素
        while (true){
            int k = list.find(X);
            if (k == -1) break;
            else list.remove(k);
        }
    }

    public static void Delete_Between(LinkedList L, T mink, T maxk){
        //删除元素递增排序的单链表L中值大于mink且小于maxk的所有元素
        Node p = L.head;
        if (mink.compareTo(maxk) < 0){
            while(p.next && p.next.data.compareTo(maxk) < 0){
                p = p.next;
            }
            if (p.next){//p是最后一个不大于mink的元素,如果还有比mink更大的元素
                Node q = p.next;
                while (q && q.data.compareTo(maxk) < 0){
                    q = q.next;
                }//q是第一个不小于maxk的元素
                p.next = q;
            }
        }
    }

    public void elredundant(linklist head){
        //在单链表中删除值相同的多余结点的算法
        Node p, q, s;
        for (p = head; p != null; p = p.next){
            for (q = p.next, s = p; q != null; ){
                if (q.data.equals(p.data)){
                    s.next = q.next;
                    q = s.next;
                }
                else{
                    s = q;
                    q = q.next;
                }
            }
        }
    }

    public void mergelklist(linklist ha, linklist hb, linklist hc){
        //两个有序单链表的合并排序算法
        linklist s = hc = null;
        while (ha && hb){
            if (ha.data.compareTo(hb.data) < 0){
                if (s == null)
                    hc = s = ha;
                else{
                    s.next = ha;
                    s = ha;
                }
                ha = ha.next;
            }
            else {
                if (s == null)
                    hc = s = hb;
                else{
                    s.next = hb;
                    s = hb;
                }
                hb = hb.next;
            }
        }
        if (ha == null)
            s.next = hb;
        else s.next = ha;
    }

    public int isriselk(linklist head){
        //判断单链表中元素是否是递增的算法
        if (head == null || head.next == null)
            return 1;
        else
            for (q = head, p = head.next; p != null; q = p, p = p.next)
                if (q.data.compareTo(p.data) > 0)
                    return 0;
                return 1;
    }

}
