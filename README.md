# CS364 Assignment 1 — BMI Calculator

โปรเจกต์แอปพลิเคชันคำนวณดัชนีมวลกาย (BMI) สำหรับรายวิชา CS364 Assignment 1

## Group Members & Responsibilities

| สมาชิก                          | รหัสนักศึกษา | หน้าที่รับผิดชอบ                | ไฟล์ที่เกี่ยวข้อง                                                                                       |
| ------------------------------- | ------------ | ------------------------------- | ------------------------------------------------------------------------------------------------------- |
| นางสาวชญาณ์นันท์ มะริวรรณ์      | 6709650219   | Landscape UI                    | `res/layout-land/activity_main.xml`                                                                     |
| นางสาวชนิภรณ์ คิมประเสริฐ       | 6709650243   | Portrait UI + Responsive Layout | `res/layout/activity_main.xml`                                                                          |
| นางสาวพัทธนันท์ บรรทัด          | 6709650516   | BMI Logic + Input Validation    | `MainActivity.java`                                                                                     |
| นางสาวพัทธนันท์ กาญจนสุทธิรักษ์ | 6709650524   | Resource + ภาษา + สี + Font     | `res/values/strings.xml`, `res/values-th/strings.xml`, `res/values/colors.xml`, `res/values/dimens.xml` |

## Assignment Features

* คำนวณค่า BMI จากน้ำหนักและส่วนสูง
* ตรวจสอบความถูกต้องของข้อมูลน้ำหนักและส่วนสูง
* แสดงผลค่า BMI โดยจัดรูปแบบทศนิยม
* แสดงระดับความเสี่ยงของ BMI พร้อมเปลี่ยนสีตามระดับ
* รองรับการแสดงผลทั้ง Portrait และ Landscape
* รองรับ Responsive Layout
* รองรับภาษาไทยและภาษาอังกฤษ
* ใช้ Resource สำหรับข้อความ สี และขนาดต่าง ๆ
* รองรับการปรับขนาดตัวอักษรตามการตั้งค่าของระบบ
