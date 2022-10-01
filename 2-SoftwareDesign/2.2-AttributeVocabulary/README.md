# Словник атрибутів об’єктів

<table>
    <thead align="center">
        <tr>
            <td>Об'єкт</td>
            <td>Атрибут</td>
            <td>Короткий опис</td>
            <td>Тип</td>
            <td>Обмеження</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Authority</td>
            <td>name</td>
            <td>Назва повноваження</td>
            <td>текст</td>
            <td>Щонайменш 5 символів</td>
        </tr>
        <tr>
            <td>Role</td>
            <td>name</td>
            <td>Назва ролі</td>
            <td>текст</td>
            <td>Щонайменш 5 символів</td>
        </tr>
        <tr>
            <td rowspan="5">User</td>
            <td>role</td>
            <td>Назва ролі користувача</td>
            <td>role</td>
            <td>Не порожнє значення</td>
        </tr>
        <tr>
            <td>name</td>
            <td>Ім'я користувача</td>
            <td>текст</td>
            <td>Щонайменш 5 символів</td>
        </tr>
        <tr>
            <td>surname</td>
            <td>Прізвище користувача</td>
            <td>текст</td>
            <td></td>
        </tr>
        <tr>
            <td>literature</td>
            <td>Колекція придбаної літератури</td>
            <td>перелік literature</td>
            <td></td>
        </tr>
        <tr>
            <td>balance</td>
            <td>Кількість грошей на рахунку користувача</td>
            <td>чисельний</td>
            <td>Не меншний за 0</td>
        </tr>
        <tr>
            <td>Genre</td>
            <td>name</td>
            <td>Назва жанру</td>
            <td>текст</td>
            <td>Не порожнє значення</td>
        </tr>
        <tr>
            <td>LiteratureType</td>
            <td>name</td>
            <td>Назва типу літератури</td>
            <td>текст</td>
            <td>Не порожнє значення</td>
        </tr>
        <tr>
            <td rowspan="6">Literature</td>
            <td>name</td>
            <td>Назва літератури</td>
            <td>текст</td>
            <td>Щонайменш 5 символів</td>
        </tr>
        <tr>
            <td>description</td>
            <td>Опис літератури</td>
            <td>текст</td>
            <td></td>
        </tr>
        <tr>
            <td>genres</td>
            <td>Жанри літератури</td>
            <td>перелік genre</td>
            <td>Щонайменш 1 жанр</td>
        </tr>
        <tr>
            <td>literatureType</td>
            <td>Тип літератури</td>
            <td>literatureType</td>
            <td>Не порожнє значення</td>
        </tr>
        <tr>
            <td>cost</td>
            <td>Вартість літератури</td>
            <td>чисельний</td>
            <td>Не меншний за 0</td>
        </tr>
        <tr>
            <td>author</td>
            <td>Автор літератури</td>
            <td>user</td>
            <td></td>
        </tr>
    </tbody>
</table>
