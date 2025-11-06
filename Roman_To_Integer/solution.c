int romanToInt(char * s){
    int i,temp,sum=0;
    for(i=0;;i++)
    {
        if (*(s+i)=='\0') break;
        else
        {
            temp=*(s+i);
        }
        if (temp=='I')
        {
            if (*(s+i+1)=='V') sum+=4,i++;
            else if (*(s+i+1)=='X') sum+=9,i++;
            else sum++;
        }
        else if (temp=='X')
        {
            if (*(s+i+1)=='L') sum+=40,i++;
            else if (*(s+i+1)=='C') sum+=90,i++;
            else sum+=10;
        }
        else if (temp=='C')
        {
            if (*(s+i+1)=='D') sum+=400,i++;
            else if (*(s+i+1)=='M') sum+=900,i++;
            else sum+=100;
        }
        else
        {
            switch (temp)
            {
                case 'V' :sum+=5;
                    break;
                case 'L' :sum+=50;
                    break;
                case 'D' :sum+=500;
                    break;
                case 'M' :sum+=1000;
                    break;
                default:break; 
            }
        }
    }
    return sum;
}
