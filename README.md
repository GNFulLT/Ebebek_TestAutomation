# Ebebek_TestAutomation

Login Case leri çıkartılıp test kodları yazıldı.

UI Sepete ekleme ve doğru eklenip eklenilmedği caseleri çıkartılıp kodları yazıldı.


E-bebek sitesinde hatalar : 

1-) Ana sayfada "addToCartBtn" id olarak tüm cart'a ekleme işlevini yerine getiren butonlara eklenmiş. ID ler tüm document içinde Unique olmalı HTML Standart kuralı.
getElementById gibi fonksyionlarda beklenmeyen durumlar oluşabilir. 

2-) Kullanılan resimlerin boyutu sadece width height ile standarize edilmiş. Saklanma boyutu değiştirilirse performans artışı olur.
