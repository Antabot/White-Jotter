# -*- coding:UTF-8 -*-
from bs4 import BeautifulSoup
from urllib.request import urlretrieve
import requests
import os
import time

if __name__ == '__main__':
    list_url = []
    for num in range(1,20):
        if num == 1:
            url = 'https://www.meitulu.com/item/8782.html'
        else:
            url = 'https://www.meitulu.com/item8782_%d.html' % num
        headers = {
                "User-Agent":"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36"
        }
        req = requests.get(url = url,headers = headers)
        req.encoding = 'utf-8'
        html = req.text
        bf = BeautifulSoup(html, 'lxml')
        targets_url = bf.find_all(class_='content_img')

        for each in targets_url:
            list_url.append(each.get('src'))
    print(list_url)

    for each_img in list_url:
        # img_bf_2 = BeautifulSoup(str(each_img), 'lxml')
        # img_url = 'http://www.shuaia.net' + img_bf_2.div.img.get('src')
        if 'images' not in os.listdir():
            os.makedirs('images')
        urlretrieve(url = each_img,filename = 'images/' + '1')
        time.sleep(1)

print('下载完成！')