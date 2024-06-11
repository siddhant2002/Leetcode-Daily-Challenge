class Solution {
    public String intToRoman(int num) {
        String arr1[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int arr2[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder nm=new StringBuilder();
        int ind=0;
        while(num>0)
        {
            if(num>=arr2[ind])
            {
                nm.append(arr1[ind]);
                num-=arr2[ind];
            }
            else
            {
                ind++;
            }
        }
        return nm.toString();
    }
}