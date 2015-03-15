/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_lru;

/**
 *
 * @author SARJIT
 */
public class LRU
{
    private int frames[][];
    private int noOfFrames;
    private int oldIndex;
    private int pageFaults;
    
    
    public LRU()
    {
        
    }
    
    public LRU(int n)
    {
        noOfFrames = n;
        frames = new int[noOfFrames][2];
        oldIndex = 0;
        pageFaults = 0;
    }
    
    public void incrementTime(int exceptIndex)
    {
        for(int i = 0; i < frames.length; i++)
        {
            if(i != exceptIndex){
                frames[i][1]++;
            }
            else
            {
                frames[i][1] = 0;
            }
        }
        getOldestIndex();
    }
    
    public void getOldestIndex()
    {
        for(int i = 0; i < frames.length; i++)
        {
            if(frames[i][1] > frames[oldIndex][1]){
                oldIndex = i;
            }
        }
    }
    
    public void addPage(int page)
    {
        boolean status = isExist(page);
        if(!status)
        {
            pageFaults++;
            frames[oldIndex][0] = page;
        }
        incrementTime(oldIndex);
        
    }
    
    public boolean isExist(int page)
    {
        for(int i = 0; i < frames.length; i++)
        {
            if(frames[i][0] == page){
                return true;
            }
        }
        return false;
    }
    
    public String printFrames()
    {
        String str = "";
        for(int i = 0; i < frames.length; i++)
        {
            str = str + frames[i][0] + " ";
        }
        return str;
    }
    
    public int getPageFaults()
    {
        return pageFaults;
    }
    
}