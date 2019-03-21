    
import requests
import re,os,threading
class myThread (threading.Thread):  
    def __init__(self, url, dir, filename):
        threading.Thread.__init__(self)
        self.threadID = filename
        self.url = url
        self.dir = dir
        self.filename=filename
    def run(self):                
        download_pic(self.url,self.dir,self.filename)
        
def download_pic(url,dir,filename):
    req=requests.get(url=url,headers=headers)
    if req.status_code==200:
        with open(str(dir)+'/'+str(filename)+'.jpg','wb') as f:
            f.write(req.content)

flag=1
headers={'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36Name','Referer':'http://www.mm131.com/'}
while True:
    if flag==1:
        get=requests.get('http://www.mm131.com/xinggan/')
        b=re.findall(r'<dd><a target="_blank" href="http://www.mm131.com/xinggan/([0-9]*).html"><img src=',get.text)
        for a in b:
            getpage=requests.get('http://www.mm131.com/xinggan/'+str(a)+'.html')
            tittle=re.findall(r'<h5>(.*)</h5>',str(getpage.content,'gb2312',errors='ignore'))
            pages=[]
            threads=[]
            pages=re.findall(r'<span class="page-ch">共(.*?)页</span>',str(getpage.content,'gb2312',errors='ignore'))
            page=pages[0]
            download_url='http://img1.mm131.me/pic/'+str(a)+'/'
            for t in tittle:
                if os.path.exists(t)==False:
                    os.makedirs(t)
                    print('开始下载：'+t)
                    for page_img in range(int(page)):
                        download_img_url=download_url+str(page_img)+'.jpg'
                        thread=myThread(download_img_url,t,page_img)
                        thread.start()
                        threads.append(thread)
                    for t in threads:
                        t.join()
                    print('下载完成')
                else:
                    print('文件夹已存在，跳过')
        flag=flag+1
        print('这一页的任务已经完成了')
    else:
        get=requests.get('http://www.mm131.com/xinggan/list_6_'+str(flag)+'.html')
        if get.status_code==200:
            b=re.findall(r'<dd><a target="_blank" href="http://www.mm131.com/xinggan/([0-9]*).html"><img src=',get.text)
            for a in b:
                getpage=requests.get('http://www.mm131.com/xinggan/'+str(a)+'.html')
                tittle=re.findall(r'<h5>(.*)</h5>',str(getpage.content,'gb2312',errors='ignore'))
                pages=[]
                threads=[]
                pages=re.findall(r'<span class="page-ch">共(.*?)页</span>',str(getpage.content,'gb2312',errors='ignore'))
                page=pages[0]
                download_url='http://img1.mm131.me/pic/'+str(a)+'/'
                for t in tittle:
                    if os.path.exists(t)==False:
                        os.makedirs(t)
                        print('开始下载：'+t)
                        for page_img in range(int(page)):
                            download_img_url=download_url+str(page_img)+'.jpg'
                            thread=myThread(download_img_url,t,page_img)
                            thread.start()
                            threads.append(thread)
                        for t in threads:
                            t.join()
                        print('下载完成')
                    else:
                        print('文件夹已存在，跳过')
            flag=flag+1
            print('这一页的任务已经完成了')
        else:
            break