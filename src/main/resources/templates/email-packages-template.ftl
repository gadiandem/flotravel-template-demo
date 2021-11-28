<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <#--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"-->
    <#--          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"-->
    <#--          crossorigin="anonymous"> -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <style type="text/css">
        th, td {
            padding: 2px;
        }
    </style>
</head>

<body>
<p style="color: #ff5e6a">Dear ${payer.firstName} ${payer.lastName},</p>
<p><b>You have ${bookingStatusDes} Packages:</b></p>
<table class="table col-12" style="border: 1px solid #0c2e5a">
    <thead>
    <tr>
        <th scope="col"></th>
        <th scope="col">Content</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Amount</td>
        <td>${amount} ${currencyName}</td>
    </tr>
    <tr>
        <td>Order Date</td>
        <td>${orderDate}</td>
    </tr>
    <tr>
        <td>Content</td>
        <td>${item_name}</td>
    </tr>
    <#if packageInfo??>
        <tr>
            <td>Package</td>
            <td>${packageInfo.name}<br/>${packageInfo.price} ${packageInfo.currency}</td>
        </tr>
    </#if>
    <tr>
        <td>Start Date</td>
        <td>${startDate}</td>
    </tr>
    <#if hotelPackage??>
        <tr>
            <td>Hotel</td>
            <td>${hotelPackage.name}<br/>${packageInfo.price} ${packageInfo.currency}</td>
        </tr>
    </#if>
    <#if hotelRooms??>
        <#list hotelRooms as room>
            <tr>
                <td>Room</td>
                <td>${room.roomType}<br/>${room.roomDescription}</td>
            </tr>
        </#list>
    </#if>
    <#if tax??>
        <tr>
            <td>Tax</td>
            <td>${tax.name}<br/>${tax.amount} ${tax.currency}</td>
        </tr>
    </#if>
    <#if supplements??>
        <#list supplements as supplement>
            <tr>
                <td>Supplement</td>
                <td>${supplement.name}<br/>${supplement.price} ${supplement.currency}</td>
            </tr>
        </#list>
    </#if>
    <#if tourInPackages??>
        <#list tourInPackages as tourInPackage>
            <tr>
                <td>Tour</td>
                <td>${tourInPackage.name}<br/>${tourInPackage.price} ${tourInPackage.currency}</td>
            </tr>
        </#list>
    </#if>
    <#if transferInPackages??>
        <#list transferInPackages as transferInPackage>
            <tr>
                <td>TransferInPackage</td>
                <td>${transferInPackage.transferType}<br/>${transferInPackage.amount} ${transferInPackage.currency}</td>
            </tr>
        </#list>
    </#if>
    <#if cancelDateReq??>
        <tr>
            <td>Cancel Date Req</td>
            <td>${cancelDateReq}</td>
        </tr>
    </#if>
    <#if reason??>
        <tr>
            <td>Reason</td>
            <td>${reason}</td>
        </tr>
    </#if>
    <#if cancelDateConfirm??>
        <tr>
            <td>Cancel Date Confirm</td>
            <td>${cancelDateConfirm}</td>
        </tr>
    </#if>
    <tr>
        <td>Tracking</td>
        <td>${tracking}</td>
    </tr>
    <tr>
        <td>Trace Number</td>
        <td>${traceNumber}</td>
    </tr>
    <tr>
        <td>Payer</td>
        <td>${payer.email}</td>
    </tr>
    <tr>
        <td>Booking Status</td>
        <td>${bookingStatusDes}</td>
    </tr>

    </tbody>
</table>
<br/>
Regards NCT
<p>View Detail booking:<a href="${refLink}">
        ${refLink}
    </a>
</p>
</body>

</html>