(()=>{
    const tbody = document.getElementById("tBody")

    const months = ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dec']

    const xhr = new XMLHttpRequest()

    xhr.open("GET","servlet-students",true )

    xhr.onreadystatechange = ()=>{
        if( xhr.readyState === 4 && xhr.status === 200 ){
            const students = JSON.parse( xhr.responseText )
            students.forEach( student => {
                const row = document.createElement("tr")

                const colId = document.createElement("td")
                colId.appendChild( document.createTextNode( student.id ) );
                row.appendChild( colId )

                const colName = document.createElement("td")
                colName.appendChild( document.createTextNode(student.name))
                row.appendChild( colName )

                const colGender = document.createElement("td")
                colGender.appendChild( document.createTextNode(student.gender == 'F' ? "Femenino" : "Masculino" ))
                row.appendChild( colGender )

                const colCity = document.createElement("td")
                colCity.appendChild( document.createTextNode(student.city))
                row.appendChild( colCity )

                const birthday = student.birthday
                const colBirthday = document.createElement("td")
                colBirthday.appendChild( document.createTextNode(`${birthday.day}-${months[birthday.month-1]}-${birthday.year}`))
                row.appendChild( colBirthday )

                tbody.appendChild(row)
            })
        }
    }

    xhr.send()
})()

document.getElementById('btnSend').addEventListener('click',()=>{
    const idStudent = document.getElementById('idStudent').value
    const name = document.getElementById('name').value
    const gender = document.getElementById('gender').value == 0 ? 'F' : 'M'
    const city = document.getElementById('city').value
    const birthday = document.getElementById('birthday').value

    const xhr = new XMLHttpRequest()

    xhr.open("POST","add-student",true)

    xhr.onreadystatechange = ()=>{
        if( xhr.readyState === 4 && xhr.status === 200 ){
           if( xhr.responseText ){
               const student = JSON.parse(xhr.responseText)
               alert("El Estudiante se inserto satisfactoriamente")

               const tbody = document.getElementById('tBody')
               const row = document.createElement("tr")

               const colId = document.createElement("td")
               colId.appendChild(document.createTextNode(student.id))
               row.appendChild( colId)

               const colName= document.createElement("td")
               colName.appendChild(document.createTextNode(student.name))
               row.appendChild( colName)

               const colGender = document.createElement("td")
               colGender.appendChild(document.createTextNode(student.gender=='F' ? "Femenino" : "Masculino"))
               row.appendChild( colGender )

               const colCity = document.createElement("td")
               colCity.appendChild(document.createTextNode(student.city))
               row.appendChild( colCity )

               const colBirthday = document.createElement("td")
               colBirthday.appendChild(document.createTextNode(birthday))
               row.appendChild( colBirthday )

               tbody.appendChild(row)
           }else{
               alert("No fue posible Insertar el Registro")
           }
        }
    }
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    const data = `name=${name}&idStudent=${idStudent}&gender=${gender}&city=${city}&birthday=${birthday}`
    xhr.send(data)
})
