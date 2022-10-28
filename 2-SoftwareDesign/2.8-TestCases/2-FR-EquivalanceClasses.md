|Опис вхідних умов|Правильний/неправильний <br> клас еквівалентності|Опис значень вхідних даних|
|:-|:-:|:-|
|1) Значення *literatureId* у діапазоні [0;1000000000]<br>2) Значення *literatureType* співпадає з одним із: "Free", "Trial" або "Paid";| Правильний | *literatureId* = *12* <br> *literatureType* = *Free*|
|1) Значення *literatureId* *НЕ* у діапазоні [0;1000000000]<br>2) Значення *literatureType* співпадає з одним із: "Free", "Trial" або "Paid";| Неправильний | *literatureId* = *1000000000000* <br> *literatureType* = *Free*|
|1) Значення *literatureId* у діапазоні [0;1000000000]<br>2) Значення *literatureType* НЕ співпадає з одним із: "Free", "Trial" або "Paid";| Неправильний | *literatureId* = *10* <br> *literatureType* = *Sale*|
|1) Значення *literatureId* НЕ у діапазоні [0;1000000000]<br>2) Значення *literatureType* НЕ співпадає з одним із: "Free", "Trial" або "Paid";| Неправильний | *literatureId* = *-100* <br> *literatureType* = *Sold*|
