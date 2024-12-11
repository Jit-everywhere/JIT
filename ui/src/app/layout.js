import "./globals.css";

export const metadata = {
  title: "Just In Time",
  description: "Your Food Your Way Right on Time",
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body className='antialiased'>
        {children}
      </body>
    </html>
  );
}
