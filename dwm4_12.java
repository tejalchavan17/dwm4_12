import java.util.*;  
class dwm4_12
{
    public static void main(String args[])
    {
        int count[]=new int[200];
        float support1[]=new float[200];
        float support2[]=new float[200];
		float support3[]=new float[200];
        int n = 5;
        int i,j,t,te,l,m,c=0,temp=1,s=0,ts=0,it=0,test=0;
        int items=10;
        float supp=40;
        ArrayList<Integer>[] trans = new ArrayList[n];
        for(i=0;i<n;i++)
                trans[i]=new ArrayList();
        trans[0].add(1); 
        trans[0].add(3);
        trans[0].add(4);
        trans[0].add(6);
        trans[1].add(2);
        trans[1].add(3);
        trans[1].add(5);
        trans[1].add(7);
        trans[2].add(1);
        trans[2].add(2);
        trans[2].add(3);
        trans[2].add(5);
        trans[2].add(8);
        trans[3].add(2);
        trans[3].add(5);
        trans[3].add(9);
        trans[3].add(10);
        trans[4].add(1);
        trans[4].add(4);
        for(i=0;i<n;i++)
            System.out.println(trans[i]); 
		System.out.println("Candidate set (C"+temp+"):");  
        for(i=1;i<=items;i++)
        {
                for(j=0;j<5;j++)
                { 
                    if(trans[j].contains(i))
                        c++;
                }
                count[i]=c;
                c=0;
        }
        for(i=1;i<=items;i++)
		{
			support1[i]=(((float)count[i]/n)*100);
            System.out.println("(" +i+")="+count[i]+" support="+support1[i]);
		}   
		System.out.println("L"+temp+":");
        for(i=1;i<=items;i++)
        {
            if(support1[i]<supp)
                support1[i]=-1;
        } 
        for(i=1;i<=items;i++)
        {
            if(support1[i]!=-1)
                System.out.println("(" +i+")="+support1[i]); 
        }
        temp++;
        
        System.out.println("Candidate set (C"+temp+"):");
        for(i=1;i<=items;i++)
        {
        	for(j=i+1;j<=items;j++)
        	{
        		if(support1[i]!=-1&&support1[j]!=-1)
        		{
        			s++;
        			for(t=0;t<n;t++)
        			{
        				if(trans[t].contains(i)&&trans[t].contains(j))
        					c++;
        			}
        			count[s]=c;
        			c=0;
        		}
        	}
        }
        s=0;
        for(i=1;i<=items;i++)
        {
        	for(j=i+1;j<=items;j++)
        	{
        		if(support1[i]!=-1&&support1[j]!=-1)
        		{
        			s++;
					support2[s]=(((float)count[s]/n)*100);
        			System.out.println("("+i+","+j+")="+count[s]+" support="+support2[s]);
        		}
        	}
        }
        System.out.println("L"+temp+":");
        for(i=1;i<=s;i++)
        {
            if(support2[i]<supp)
                support2[i]=-1;
        } 
        s=0;
        for(i=1;i<=items;i++)
        {
        	for(j=i+1;j<=items;j++)
        	{
        		if(support1[i]!=-1&&support1[j]!=-1)
        		{
        			s++;
        			if(support2[s]!=-1)
        			{
        			
        				System.out.println("("+i+","+j+")="+support2[s]);
        			}
        		}
        	}
        	
        }
        temp++;
        
		s=0;c=0;
       	System.out.println("Candidate set (C"+temp+"):");
        for(i=1;i<=items;i++)
        {
        	for(j=i+1;j<=items;j++)
        	{
        		if(support1[i]!=-1&&support1[j]!=-1)
        		{
        			s++;
        			if(support2[s]!=-1)
        			{
        				for(l=1;l<=items;l++)
						{
							for(m=l+1;m<=items;m++)
							{
								if(support1[l]!=-1&&support1[m]!=-1)
								{
									ts++;
									if(support2[ts]!=-1)
									{
										if(i!=l&&j==m)
										{
											it++;
											for(t=0;t<5;t++)
											{
												if(trans[t].contains(i)&&trans[t].contains(j)&&trans[t].contains(l))
												c++;
											}
											count[it]=c;
											c=0;
										}
										if(i==l&&j!=m)
										{
											it++;
											for(t=0;t<5;t++)
											{
												if(trans[t].contains(i)&&trans[t].contains(j)&&trans[t].contains(m))
												c++;
											}
											count[it]=c;
											c=0;
										}
										if(i!=m&&j==l)
										{
											it++;
											for(t=0;t<5;t++)
											{
												if(trans[t].contains(i)&&trans[t].contains(j)&&trans[t].contains(m))
												c++;
											}
											count[it]=c;
											c=0;
										}
										if(i==m&&j!=l)
										{
											it++;
											for(t=0;t<5;t++)
											{
												if(trans[t].contains(i)&&trans[t].contains(j)&&trans[t].contains(l))
												c++;
											}
											count[it]=c;
											c=0;
										}
									}
        						}
        					}
        				}
						ts=0;
        			}
				}
			}
        }
		s=0;ts=0;
        for(i=1;i<=items;i++)
        {
        	for(j=i+1;j<=items;j++)
        	{
        		if(support1[i]!=-1&&support1[j]!=-1)
        		{
        			s++;
        			if(support2[s]!=-1)
        			{
        				for(l=1;l<=items;l++)
						{
							for(m=l+1;m<=items;m++)
							{
								if(support1[l]!=-1&&support1[m]!=-1)
								{
									ts++;
									if(support2[ts]!=-1)
									{
										if(i!=l&&j==m)
										{
											test++;
											support3[test]=(((float)count[test]/n)*100);		
											System.out.println("("+i+","+j+","+l+")="+count[test]+" support="+support3[test]);
										}
										if(i==l&&j!=m)
										{
											test++;
											support3[test]=(((float)count[test]/n)*100);		
											System.out.println("("+i+","+j+","+m+")="+count[test]+" support="+support3[test]);
										}
										if(i!=m&&j==l)
										{
											test++;
											support3[test]=(((float)count[test]/n)*100);		
											System.out.println("("+i+","+j+","+m+")="+count[test]+" support="+support3[test]);
										}
										if(i==m&&j!=l)
										{
											test++;
											support3[test]=(((float)count[test]/n)*100);		
											System.out.println("("+i+","+j+","+l+")="+count[test]+" support="+support3[test]);
										}
									}
        						}
        					}
        				}
						ts=0;
        			}
				}
			}
        }
		System.out.println("L"+temp);
		for(i=1;i<=test;i++)
        {
            if(support3[i]<supp)
                support3[i]=-1;
        } 
		s=0;ts=0;test=0;
        for(i=1;i<=items;i++)
        {
        	for(j=i+1;j<=items;j++)
        	{
        		if(support1[i]!=-1&&support1[j]!=-1)
        		{
        			s++;
        			if(support2[s]!=-1)
        			{
        				for(l=1;l<=items;l++)
						{
							for(m=l+1;m<=items;m++)
							{
								if(support1[l]!=-1&&support1[m]!=-1)
								{
									ts++;
									if(support2[ts]!=-1)
									{
										if(i!=l&&j==m)
										{
											test++;
											if(support3[test]!=-1)		
												System.out.println("("+i+","+j+","+l+")="+support3[test]);
										}
										if(i==l&&j!=m)
										{
											test++;
											if(support3[test]!=-1)		
												System.out.println("("+i+","+j+","+m+")="+support3[test]);
										}
										if(i!=m&&j==l)
										{
											test++;
											if(support3[test]!=-1)		
												System.out.println("("+i+","+j+","+m+")="+support3[test]);
										}
										if(i==m&&j!=l)
										{
											test++;
											if(support3[test]!=-1)		
												System.out.println("("+i+","+j+","+l+")="+support3[test]);
										}
									}
        						}
        					}
        				}
						ts=0;
        			}
				}
			}
        }
	}
}
/*Output
tejal@ubuntu:~/Desktop$ javac dwm4_12.java
Note: dwm3.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
tejal@ubuntu:~/Desktop$ java dwm4_12
[1, 3, 4, 6]
[2, 3, 5, 7]
[1, 2, 3, 5, 8]
[2, 5, 9, 10]
[1, 4]
Candidate set (C1):
(1)=3 support=60.000004
(2)=3 support=60.000004
(3)=3 support=60.000004
(4)=2 support=40.0
(5)=3 support=60.000004
(6)=1 support=20.0
(7)=1 support=20.0
(8)=1 support=20.0
(9)=1 support=20.0
(10)=1 support=20.0
L1:
I1=60.000004
I2=60.000004
I3=60.000004
I4=40.0
I5=60.000004
Candidate set (C2):
(1,2)=1 support=20.0
(1,3)=2 support=40.0
(1,4)=2 support=40.0
(1,5)=1 support=20.0
(2,3)=2 support=40.0
(2,4)=0 support=0.0
(2,5)=3 support=60.000004
(3,4)=1 support=20.0
(3,5)=2 support=40.0
(4,5)=0 support=0.0
L2:
(1,3)=40.0
(1,4)=40.0
(2,3)=40.0
(2,5)=60.000004
(3,5)=40.0
Candidate set (C3):
(1,3,4)=1 support=20.0
(1,3,2)=1 support=20.0
(1,3,5)=1 support=20.0
(2,3,5)=2 support=40.0
L3
(2,3,5)=40.0
tejal@ubuntu:~/Desktop$ 
*/
