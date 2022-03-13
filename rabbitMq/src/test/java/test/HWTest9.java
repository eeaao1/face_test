package test;

import org.junit.Test;

/*********************************************************
 * 文件名称：
 * 系统名称：交易银行系统V2.0
 * 模块名称：test
 * 功能说明：
 * 开发人员：kongli26489
 * 开发时间：2021/5/15 21:11
 * 修改记录：程序版本  修改日期  修改人员  修改单号  修改说明
 *********************************************************/
public class HWTest9 {
    @Test
    public void s(){
        int[] arr ={3,1,2,5,2,4};

        System.out.println(maxWater(arr));
    }

    public long maxWater (int[] arr) {
        // write code here
        if(arr==null || arr.length==0){
            return 0;
        }
        int left =0;
        int right=arr.length-1;
        long res=0L;
        while(left<right){
            int miner=arr[left]>arr[right]?arr[right]:arr[left];
            while(left<right && arr[left]<=miner){
                res+=miner-arr[left];
                left++;
            }
            while(left<right && arr[right]<=miner){
                res+=miner-arr[right];
                right--;
            }
        }
        return res;
    }

}
