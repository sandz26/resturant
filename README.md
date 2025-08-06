# Sandile Mdluli - Web CV

A modern, responsive web CV built with HTML, CSS, and JavaScript. This CV showcases Sandile's skills, experience, and achievements in an interactive and professional format.

## 🌟 Features

- **Modern Design**: Clean, professional layout with gradient backgrounds
- **Responsive**: Works perfectly on desktop, tablet, and mobile devices
- **Interactive**: Smooth animations and hover effects
- **Print-Friendly**: Optimized for printing (Ctrl+P or print button)
- **Accessible**: Semantic HTML and keyboard navigation
- **Fast Loading**: Optimized performance with minimal dependencies

## 📁 File Structure

```
web-cv/
├── index.html          # Main HTML file
├── styles.css          # CSS styles and responsive design
├── script.js           # JavaScript for interactivity
└── README.md           # This file
```

## 🚀 How to Use

### Viewing the CV
1. Open `index.html` in any modern web browser
2. The CV will load with smooth animations
3. Use the print button (top-right) or Ctrl+P to print/save as PDF

### Customizing the CV

#### Personal Information
Edit the header section in `index.html`:
```html
<div class="profile-info">
    <h1 class="name">Your Name</h1>
    <h2 class="title">Your Title</h2>
    <p class="location"><i class="fas fa-map-marker-alt"></i> Your Location</p>
</div>
```

#### Contact Information
Update the contact links in the header:
```html
<div class="contact-info">
    <a href="tel:your-phone" class="contact-item">
        <i class="fas fa-phone"></i> Your Phone
    </a>
    <a href="mailto:your-email" class="contact-item">
        <i class="fas fa-envelope"></i> Your Email
    </a>
    <!-- Add more contact items as needed -->
</div>
```

#### Experience Section
Add or modify experience items:
```html
<div class="experience-item">
    <div class="experience-header">
        <h4 class="job-title">Job Title</h4>
        <span class="company">Company Name</span>
        <span class="duration">Start Date - End Date</span>
    </div>
    <p class="location-small">Location</p>
    <ul class="achievements">
        <li>Achievement 1</li>
        <li>Achievement 2</li>
        <!-- Add more achievements -->
    </ul>
</div>
```

#### Skills Section
Organize skills by category:
```html
<div class="skill-category">
    <h4>Category Name</h4>
    <div class="skill-tags">
        <span class="skill-tag">Skill 1</span>
        <span class="skill-tag">Skill 2</span>
        <!-- Add more skills -->
    </div>
</div>
```

## 🎨 Customization Options

### Colors
The CV uses a purple gradient theme. To change colors, edit the CSS variables in `styles.css`:

```css
/* Main gradient colors */
background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);

/* Section border colors */
border-left: 4px solid #667eea;  /* Experience */
border-left: 3px solid #48bb78;  /* Education */
border-left: 3px solid #ed8936;  /* Skills */
border-left: 3px solid #f56565;  /* Certifications */
border-left: 3px solid #9f7aea;  /* Volunteering */
```

### Fonts
The CV uses Inter font. To change fonts, update the font-family in `styles.css`:
```css
font-family: 'Inter', -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
```

### Layout
The CV uses CSS Grid and Flexbox for responsive layout. Modify the grid templates in `styles.css` to change the layout structure.

## 📱 Responsive Design

The CV is fully responsive with breakpoints at:
- **Desktop**: 1200px and above
- **Tablet**: 768px - 1199px
- **Mobile**: Below 768px

## 🖨️ Print Optimization

The CV includes print-specific styles that:
- Remove background colors and shadows
- Optimize layout for A4 paper
- Ensure proper page breaks
- Maintain readability

## 🌐 Deployment Options

### GitHub Pages
1. Create a new repository on GitHub
2. Upload all files to the repository
3. Go to Settings > Pages
4. Select source branch (usually `main`)
5. Your CV will be available at `https://username.github.io/repository-name`

### Netlify
1. Drag and drop the folder to [Netlify](https://netlify.com)
2. Your CV will be deployed instantly
3. Get a custom domain if desired

### Vercel
1. Install Vercel CLI: `npm i -g vercel`
2. Run `vercel` in the project directory
3. Follow the prompts to deploy

### Local Server
For development, you can use any local server:
```bash
# Python 3
python -m http.server 8000

# Node.js (with http-server)
npx http-server

# PHP
php -S localhost:8000
```

## 🔧 Browser Support

- Chrome 60+
- Firefox 55+
- Safari 12+
- Edge 79+

## 📋 Sections Included

1. **Header**: Name, title, location, and contact information
2. **Professional Summary**: Brief overview of background and goals
3. **Experience**: Work history with achievements
4. **Education**: Academic background
5. **Skills**: Technical skills organized by category
6. **Certifications**: Professional certifications
7. **Volunteering**: Community involvement
8. **Interests**: Personal interests and hobbies

## 🎯 Tips for Success

1. **Keep it Updated**: Regularly update your experience and skills
2. **Customize**: Tailor the content to match job requirements
3. **Optimize**: Use relevant keywords for ATS systems
4. **Test**: Check the CV on different devices and browsers
5. **Print Test**: Always test the print version before sending

## 🤝 Contributing

Feel free to fork this project and customize it for your own use. If you make improvements, consider sharing them with the community!

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 📞 Support

If you need help customizing your CV or have questions, feel free to reach out!

---

**Built with ❤️ for showcasing professional achievements**